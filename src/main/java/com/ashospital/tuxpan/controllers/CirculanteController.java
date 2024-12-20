package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Circulante;
import com.ashospital.tuxpan.services.CirculanteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/circulantes")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class CirculanteController {
    private final CirculanteService circulanteService;

    public CirculanteController(CirculanteService circulanteService) {
        this.circulanteService = circulanteService;
    }

    @GetMapping
    public ResponseEntity<List<Circulante>> listarTodos() {
        return ResponseEntity.ok(circulanteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Circulante> buscarPorId(@PathVariable Long id) {
        return circulanteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Circulante> crear(@Valid @RequestBody Circulante circulante) {
        return ResponseEntity.ok(circulanteService.guardar(circulante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        circulanteService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
