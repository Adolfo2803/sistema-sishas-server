package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Paciente;
import com.ashospital.tuxpan.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")  // Solo usuarios autenticados pueden acceder
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody Paciente paciente) {
        return pacienteService.crearPaciente(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPaciente(@PathVariable Long id,
                                                @Valid @RequestBody Paciente paciente) {
        return pacienteService.actualizarPaciente(id, paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPaciente(@PathVariable Long id) {
        return pacienteService.obtenerPaciente(id);
    }

    @GetMapping
    public ResponseEntity<?> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        return pacienteService.eliminarPaciente(id);
    }

    @GetMapping("/expediente/{expediente}")
    public ResponseEntity<?> buscarPorExpediente(@PathVariable String expediente) {
        return pacienteService.buscarPorExpediente(expediente);
    }

    @GetMapping("/curp/{curp}")
    public ResponseEntity<?> buscarPorCurp(@PathVariable String curp) {
        return pacienteService.buscarPorCurp(curp);
    }
}