package com.ashospital.tuxpan.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity

@Table(name = "residentes")
public class Residente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;
    private LocalDateTime createdAt;
    private Integer numeroResidencia;

    public Residente() {
    }

    public Residente(Long id, String nombre, String especialidad, LocalDateTime createdAt, Integer numeroResidencia) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.createdAt = createdAt;
        this.numeroResidencia = numeroResidencia;
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

    public Integer getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(Integer numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }
}
