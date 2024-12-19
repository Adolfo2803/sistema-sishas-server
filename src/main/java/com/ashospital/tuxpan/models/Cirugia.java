package com.ashospital.tuxpan.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

// Entidad Cirugia
@Entity
@Table(name = "cirugias")
public class Cirugia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroCirugia;

    private Integer numeroQuirofano;
    private LocalDate fechaCirugia;
    private LocalTime iniciaAnestesia;
    private LocalTime terminaAnestesia;
    private String material;
    private String medicamento;
    private String suturas;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "cirujano_id", nullable = false)
    private Cirujano cirujano;

    @ManyToOne
    @JoinColumn(name = "anestesiologo_id", nullable = false)
    private Anestesiologo anestesiologo;

    @ManyToOne
    @JoinColumn(name = "instrumentista_id", nullable = false)
    private Instrumentista instrumentista;

    @ManyToOne
    @JoinColumn(name = "circulante_id", nullable = false)
    private Circulante circulante;

    @ManyToMany
    @JoinTable(
            name = "cirugia_residentes",
            joinColumns = @JoinColumn(name = "cirugia_id"),
            inverseJoinColumns = @JoinColumn(name = "residente_id")
    )
    private Set<Residente> residentes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cirugia_internos",
            joinColumns = @JoinColumn(name = "cirugia_id"),
            inverseJoinColumns = @JoinColumn(name = "interno_id")
    )
    private Set<Interno> internos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "cirugia_apoyo_externo",
            joinColumns = @JoinColumn(name = "cirugia_id"),
            inverseJoinColumns = @JoinColumn(name = "apoyo_id")
    )
    private Set<ApoyoExterno> apoyoExterno = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Cirugia() {
    }

    public Cirugia(Long id, String numeroCirugia, Integer numeroQuirofano, LocalDate fechaCirugia, LocalTime iniciaAnestesia, LocalTime terminaAnestesia, String material, String medicamento, String suturas, Paciente paciente, Cirujano cirujano, Anestesiologo anestesiologo, Instrumentista instrumentista, Circulante circulante, Set<Residente> residentes, Set<Interno> internos, Set<ApoyoExterno> apoyoExterno, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.numeroCirugia = numeroCirugia;
        this.numeroQuirofano = numeroQuirofano;
        this.fechaCirugia = fechaCirugia;
        this.iniciaAnestesia = iniciaAnestesia;
        this.terminaAnestesia = terminaAnestesia;
        this.material = material;
        this.medicamento = medicamento;
        this.suturas = suturas;
        this.paciente = paciente;
        this.cirujano = cirujano;
        this.anestesiologo = anestesiologo;
        this.instrumentista = instrumentista;
        this.circulante = circulante;
        this.residentes = residentes;
        this.internos = internos;
        this.apoyoExterno = apoyoExterno;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCirugia() {
        return numeroCirugia;
    }

    public void setNumeroCirugia(String numeroCirugia) {
        this.numeroCirugia = numeroCirugia;
    }

    public Integer getNumeroQuirofano() {
        return numeroQuirofano;
    }

    public void setNumeroQuirofano(Integer numeroQuirofano) {
        this.numeroQuirofano = numeroQuirofano;
    }

    public LocalDate getFechaCirugia() {
        return fechaCirugia;
    }

    public void setFechaCirugia(LocalDate fechaCirugia) {
        this.fechaCirugia = fechaCirugia;
    }

    public LocalTime getIniciaAnestesia() {
        return iniciaAnestesia;
    }

    public void setIniciaAnestesia(LocalTime iniciaAnestesia) {
        this.iniciaAnestesia = iniciaAnestesia;
    }

    public LocalTime getTerminaAnestesia() {
        return terminaAnestesia;
    }

    public void setTerminaAnestesia(LocalTime terminaAnestesia) {
        this.terminaAnestesia = terminaAnestesia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getSuturas() {
        return suturas;
    }

    public void setSuturas(String suturas) {
        this.suturas = suturas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cirujano getCirujano() {
        return cirujano;
    }

    public void setCirujano(Cirujano cirujano) {
        this.cirujano = cirujano;
    }

    public Anestesiologo getAnestesiologo() {
        return anestesiologo;
    }

    public void setAnestesiologo(Anestesiologo anestesiologo) {
        this.anestesiologo = anestesiologo;
    }

    public Instrumentista getInstrumentista() {
        return instrumentista;
    }

    public void setInstrumentista(Instrumentista instrumentista) {
        this.instrumentista = instrumentista;
    }

    public Circulante getCirculante() {
        return circulante;
    }

    public void setCirculante(Circulante circulante) {
        this.circulante = circulante;
    }

    public Set<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(Set<Residente> residentes) {
        this.residentes = residentes;
    }

    public Set<Interno> getInternos() {
        return internos;
    }

    public void setInternos(Set<Interno> internos) {
        this.internos = internos;
    }

    public Set<ApoyoExterno> getApoyoExterno() {
        return apoyoExterno;
    }

    public void setApoyoExterno(Set<ApoyoExterno> apoyoExterno) {
        this.apoyoExterno = apoyoExterno;
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