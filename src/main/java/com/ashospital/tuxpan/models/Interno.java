package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "internos")
public class Interno extends PersonalBase {
    // Campos específicos de interno si los hubiera
}
