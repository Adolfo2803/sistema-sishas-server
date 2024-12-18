package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByExpediente(String expediente);
    Optional<Paciente> findByCurp(String curp);
    boolean existsByExpediente(String expediente);
    boolean existsByCurp(String curp);


}
