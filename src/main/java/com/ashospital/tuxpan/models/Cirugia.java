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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}