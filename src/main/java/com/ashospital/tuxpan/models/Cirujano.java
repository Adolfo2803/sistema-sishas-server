package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

// Entidad Cirujano
@Entity
@Data
@Table(name = "cirujanos")
public class Cirujano extends PersonalBase {

}
