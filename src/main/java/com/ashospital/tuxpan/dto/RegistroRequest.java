package com.ashospital.tuxpan.dto;

import com.ashospital.tuxpan.enums.RolUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroRequest {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 50, message = "El nombre de usuario debe tener entre 4 y 50 caracteres")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    private RolUsuario rol;

    public RegistroRequest() {
    }

    public RegistroRequest(String username, String password, RolUsuario rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public @NotBlank(message = "El nombre de usuario es obligatorio") @Size(min = 4, max = 50, message = "El nombre de usuario debe tener entre 4 y 50 caracteres") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "El nombre de usuario es obligatorio") @Size(min = 4, max = 50, message = "El nombre de usuario debe tener entre 4 y 50 caracteres") String username) {
        this.username = username;
    }

    public @NotBlank(message = "La contraseña es obligatoria") @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es obligatoria") @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres") String password) {
        this.password = password;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}