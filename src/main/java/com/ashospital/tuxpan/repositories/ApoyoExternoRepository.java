package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.ApoyoExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoyoExternoRepository extends JpaRepository<ApoyoExterno, Long> {}
