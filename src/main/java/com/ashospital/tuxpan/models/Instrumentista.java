package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "instrumentistas")
public class Instrumentista extends PersonalBase {
    // Campos específicos de instrumentista si los hubiera
}
