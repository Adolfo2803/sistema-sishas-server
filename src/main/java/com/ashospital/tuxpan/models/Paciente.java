package com.ashospital.tuxpan.models;

import com.ashospital.tuxpan.enums.StatusPaciente;
import com.ashospital.tuxpan.enums.TipoSexo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Entidad Paciente
@Entity
@Setter
@Getter
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String expediente;

    @Column(nullable = false)
    private String nombre;
    private String apPaterno;
    private String apMaterno;

    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    private Integer edad;

    @Column(unique = true, nullable = false)
    private String curp;

    private String domicilio;
    private String telefono;
    private String ubicacion;
    private LocalDate fechaElab;

    @Enumerated(EnumType.STRING)
    private StatusPaciente status;

    @ManyToOne
    @JoinColumn(name = "elaboro_id")
    private Usuario elaboro;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Paciente() {
    }

    public Paciente(Long id, String expediente, String nombre, String apPaterno, String apMaterno, TipoSexo sexo, Integer edad, String curp, String domicilio, String telefono, String ubicacion, LocalDate fechaElab, StatusPaciente status, Usuario elaboro, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.expediente = expediente;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.sexo = sexo;
        this.edad = edad;
        this.curp = curp;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.fechaElab = fechaElab;
        this.status = status;
        this.elaboro = elaboro;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaElab() {
        return fechaElab;
    }

    public void setFechaElab(LocalDate fechaElab) {
        this.fechaElab = fechaElab;
    }

    public StatusPaciente getStatus() {
        return status;
    }

    public void setStatus(StatusPaciente status) {
        this.status = status;
    }

    public Usuario getElaboro() {
        return elaboro;
    }

    public void setElaboro(Usuario elaboro) {
        this.elaboro = elaboro;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
