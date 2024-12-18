package com.ashospital.tuxpan.dto;

import lombok.Data;
import lombok.AllArgsConstructor;



import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {
    @JsonProperty("token")
    private String token;

    @JsonProperty("tipo")
    private String tipo = "Bearer";

    @JsonProperty("username")
    private String username;

    @JsonProperty("rol")
    private String rol;

    public JwtResponse(String token) {
        this.token = token;
        this.tipo = "Bearer";
    }

    public JwtResponse(String token, String tipo, String username, String rol) {
        this.token = token;
        this.tipo = tipo;
        this.username = username;
        this.rol = rol;
    }
}