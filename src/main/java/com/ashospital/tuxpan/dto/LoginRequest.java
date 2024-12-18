package com.ashospital.tuxpan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;





    public @NotBlank(message = "El nombre de usuario es obligatorio") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "El nombre de usuario es obligatorio") String username) {
        this.username = username;
    }

    public @NotBlank(message = "La contraseña es obligatoria") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es obligatoria") String password) {
        this.password = password;
    }
}
