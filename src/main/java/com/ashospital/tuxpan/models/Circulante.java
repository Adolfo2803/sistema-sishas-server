package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

// Entidad Circulante
@Entity
@Data
@Table(name = "circulantes")
public class Circulante extends PersonalBase {
    // Campos específicos de circulante si los hubiera
}