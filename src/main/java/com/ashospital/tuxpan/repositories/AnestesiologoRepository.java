package com.ashospital.tuxpan.repositories;

import com.ashospital.tuxpan.models.Anestesiologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnestesiologoRepository extends JpaRepository<Anestesiologo, Long> {}
