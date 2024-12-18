package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "residentes")
public class Residente extends PersonalBase {
    private Integer numeroResidencia;
}
