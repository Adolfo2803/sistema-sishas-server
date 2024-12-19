package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Cirugia;
import com.ashospital.tuxpan.models.Paciente;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CirugiaRepository extends JpaRepository<Cirugia, Long> {
    Optional<Cirugia> findByPaciente(String expediente);
    Optional<Cirugia> findByNumeroCirugia(String numCirugia);

}
