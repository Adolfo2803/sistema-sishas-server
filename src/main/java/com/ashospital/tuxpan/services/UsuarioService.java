package com.ashospital.tuxpan.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import com.ashospital.tuxpan.dto.LoginRequest;
import com.ashospital.tuxpan.dto.RegistroRequest;
import com.ashospital.tuxpan.dto.JwtResponse;
import com.ashospital.tuxpan.models.Usuario;
import com.ashospital.tuxpan.repositories.UsuarioRepository;
import com.ashospital.tuxpan.security.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> registrarUsuario(RegistroRequest request) {
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest()
                    .body("El nombre de usuario ya existe");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(request.getRol());
        usuario.setCreatedAt(LocalDateTime.now());

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

    public ResponseEntity<JwtResponse> login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtService.generateToken(userDetails);

            Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("Error: Usuario no encontrado"));

            // Actualizar lastLogin
            usuario.setLastLogin(LocalDateTime.now());
            usuarioRepository.save(usuario);

            JwtResponse response = new JwtResponse(
                    jwt,
                    "Bearer",
                    usuario.getUsername(),
                    usuario.getRol().name()
            );

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Error de autenticación: Credenciales inválidas");
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }



}