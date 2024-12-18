package com.ashospital.tuxpan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "apoyo_externo")
public class ApoyoExterno extends PersonalBase {
    private String especialidad;
}
