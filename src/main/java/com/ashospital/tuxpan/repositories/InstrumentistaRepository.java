package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Instrumentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentistaRepository extends JpaRepository<Instrumentista, Long> {}
