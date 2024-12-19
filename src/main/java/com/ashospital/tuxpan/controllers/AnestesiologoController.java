package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Anestesiologo;
import com.ashospital.tuxpan.services.AnestesiologoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anestesiologos")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class AnestesiologoController {
    private final AnestesiologoService anestesiologoService;

    public AnestesiologoController(AnestesiologoService anestesiologoService) {
        this.anestesiologoService = anestesiologoService;
    }

    @GetMapping
    public ResponseEntity<List<Anestesiologo>> listarTodos() {
        return ResponseEntity.ok(anestesiologoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anestesiologo> buscarPorId(@PathVariable Long id) {
        return anestesiologoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Anestesiologo> crear(@Valid @RequestBody Anestesiologo anestesiologo) {
        return ResponseEntity.ok(anestesiologoService.guardar(anestesiologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        anestesiologoService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
