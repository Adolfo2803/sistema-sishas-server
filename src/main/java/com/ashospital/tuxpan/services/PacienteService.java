package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.enums.StatusPaciente;
import com.ashospital.tuxpan.models.Paciente;
import com.ashospital.tuxpan.models.Usuario;
import com.ashospital.tuxpan.repositories.PacienteRepository;
import com.ashospital.tuxpan.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service

public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    public PacienteService(PacienteRepository pacienteRepository, UsuarioRepository usuarioRepository) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<?> crearPaciente(Paciente paciente) {
        // Validar si ya existe el expediente o CURP
        if (pacienteRepository.existsByExpediente(paciente.getExpediente())) {
            return ResponseEntity.badRequest()
                    .body("Ya existe un paciente con este número de expediente");
        }
        if (pacienteRepository.existsByCurp(paciente.getCurp())) {
            return ResponseEntity.badRequest()
                    .body("Ya existe un paciente con esta CURP");
        }

        // Obtener el usuario autenticado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuarioAutenticado = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Establecer valores por defecto
        paciente.setFechaElab(LocalDate.now());
        paciente.setStatus(StatusPaciente.ACTIVO);
        paciente.setCreatedAt(LocalDateTime.now());
        paciente.setUpdatedAt(LocalDateTime.now());
        paciente.setElaboro(usuarioAutenticado); // Asignar el usuario que elabora

        Paciente nuevoPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    public ResponseEntity<?> actualizarPaciente(Long id, Paciente pacienteActualizado) {
        return pacienteRepository.findById(id)
                .map(pacienteExistente -> {
                    // Verificar si el nuevo expediente ya existe en otro paciente
                    if (!pacienteExistente.getExpediente().equals(pacienteActualizado.getExpediente()) &&
                            pacienteRepository.existsByExpediente(pacienteActualizado.getExpediente())) {
                        return ResponseEntity.badRequest()
                                .body("Ya existe un paciente con este número de expediente");
                    }

                    // Verificar si la nueva CURP ya existe en otro paciente
                    if (!pacienteExistente.getCurp().equals(pacienteActualizado.getCurp()) &&
                            pacienteRepository.existsByCurp(pacienteActualizado.getCurp())) {
                        return ResponseEntity.badRequest()
                                .body("Ya existe un paciente con esta CURP");
                    }

                    // Actualizar campos
                    pacienteExistente.setNombre(pacienteActualizado.getNombre());
                    pacienteExistente.setApPaterno(pacienteActualizado.getApPaterno());
                    pacienteExistente.setApMaterno(pacienteActualizado.getApMaterno());
                    pacienteExistente.setSexo(pacienteActualizado.getSexo());
                    pacienteExistente.setEdad(pacienteActualizado.getEdad());
                    pacienteExistente.setDomicilio(pacienteActualizado.getDomicilio());
                    pacienteExistente.setTelefono(pacienteActualizado.getTelefono());
                    pacienteExistente.setUbicacion(pacienteActualizado.getUbicacion());
                    pacienteExistente.setUpdatedAt(LocalDateTime.now());

                    return ResponseEntity.ok(pacienteRepository.save(pacienteExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> obtenerPaciente(Long id) {
        return pacienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> listarPacientes() {
        return ResponseEntity.ok(pacienteRepository.findAll());
    }

    public ResponseEntity<?> eliminarPaciente(Long id) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setStatus(StatusPaciente.INACTIVO);
                    pacienteRepository.save(paciente);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> buscarPorExpediente(String expediente) {
        return pacienteRepository.findByExpediente(expediente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> buscarPorCurp(String curp) {
        return pacienteRepository.findByCurp(curp)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
