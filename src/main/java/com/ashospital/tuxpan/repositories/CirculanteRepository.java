package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Circulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirculanteRepository extends JpaRepository<Circulante, Long> {}