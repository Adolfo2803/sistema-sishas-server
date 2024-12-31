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
    private String type = "Bearer";

    @JsonProperty("username")
    private String username;

    @JsonProperty("rol")
    private String rol;

    public JwtResponse(String token) {
        this.token = token;
        this.type = "Bearer";
    }

    public JwtResponse(String token, String type, String username, String rol) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.rol = rol;
    }
}