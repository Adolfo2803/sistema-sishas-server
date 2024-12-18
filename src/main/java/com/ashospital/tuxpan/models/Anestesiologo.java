package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

// Entidad Anestesiologo
@Entity
@Data
@Table(name = "anestesiologos")
public class Anestesiologo extends PersonalBase {
    private String numeroColegiado;
}
