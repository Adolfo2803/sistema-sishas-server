package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Cirugia;
import com.ashospital.tuxpan.models.Paciente;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CirugiaRepository extends JpaRepository<Cirugia, Long> {
    // Buscar por número de cirugía
    Optional<Cirugia> findByNumeroCirugia(String numeroCirugia);

    // Buscar por fecha de cirugía
    List<Cirugia> findByFechaCirugia(LocalDate fechaCirugia);

    // Buscar por número de quirófano
    List<Cirugia> findByNumeroQuirofano(Integer numeroQuirofano);

    // Buscar por paciente
    List<Cirugia> findByPacienteId(Long pacienteId);

    // Buscar por cirujano
    List<Cirugia> findByCirujanoId(Long cirujanoId);

    // Buscar por anestesiólogo
    List<Cirugia> findByAnestesiologoId(Long anestesiologoId);

    // Buscar cirugías entre fechas
    List<Cirugia> findByFechaCirugiaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    // Verificar si existe una cirugía por su número
    boolean existsByNumeroCirugia(String numeroCirugia);

    // Buscar cirugías por instrumentista
    List<Cirugia> findByInstrumentistaId(Long instrumentistaId);

    // Buscar cirugías por circulante
    List<Cirugia> findByCirculanteId(Long circulanteId);

}
