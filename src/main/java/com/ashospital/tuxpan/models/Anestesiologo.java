package com.ashospital.tuxpan.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// Entidad Anestesiologo
@Entity

@Table(name = "anestesiologos")
public class Anestesiologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;
    private LocalDateTime createdAt;
    private String numeroColegiado;

    public Anestesiologo() {
    }

    public Anestesiologo(Long id, String nombre, String especialidad, LocalDateTime createdAt, String numeroColegiado) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.createdAt = createdAt;
        this.numeroColegiado = numeroColegiado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }
}
