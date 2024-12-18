package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Interno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternoRepository extends JpaRepository<Interno, Long> {}