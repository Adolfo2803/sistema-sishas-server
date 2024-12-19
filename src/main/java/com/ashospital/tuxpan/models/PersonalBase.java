package com.ashospital.tuxpan.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


// Entidad PersonalBase
@MappedSuperclass
@Data
public abstract class PersonalBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;
    private LocalDateTime createdAt;
}