package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Interno;
import com.ashospital.tuxpan.services.InternoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internos")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class InternoController {
    private final InternoService internoService;

    public InternoController(InternoService internoService) {
        this.internoService = internoService;
    }

    @GetMapping
    public ResponseEntity<List<Interno>> listarTodos() {
        return ResponseEntity.ok(internoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interno> buscarPorId(@PathVariable Long id) {
        return internoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Interno> crear(@Valid @RequestBody Interno interno) {
        return ResponseEntity.ok(internoService.guardar(interno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        internoService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}