package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Cirujano;
import com.ashospital.tuxpan.services.CirujanoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cirujanos")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class CirujanoController {
    private final CirujanoService cirujanoService;

    public CirujanoController(CirujanoService cirujanoService) {
        this.cirujanoService = cirujanoService;
    }

    @GetMapping
    public ResponseEntity<List<Cirujano>> listarTodos() {
        return ResponseEntity.ok(cirujanoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cirujano> buscarPorId(@PathVariable Long id) {
        return cirujanoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cirujano> crear(@Valid @RequestBody Cirujano cirujano) {
        return ResponseEntity.ok(cirujanoService.guardar(cirujano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cirujanoService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
