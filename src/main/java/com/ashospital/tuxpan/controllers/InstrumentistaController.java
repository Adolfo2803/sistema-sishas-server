package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Instrumentista;
import com.ashospital.tuxpan.services.InstrumentistaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrumentistas")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class InstrumentistaController {
    private final InstrumentistaService instrumentistaService;

    public InstrumentistaController(InstrumentistaService instrumentistaService) {
        this.instrumentistaService = instrumentistaService;
    }

    @GetMapping
    public ResponseEntity<List<Instrumentista>> listarTodos() {
        return ResponseEntity.ok(instrumentistaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrumentista> buscarPorId(@PathVariable Long id) {
        return instrumentistaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Instrumentista> crear(@Valid @RequestBody Instrumentista instrumentista) {
        return ResponseEntity.ok(instrumentistaService.guardar(instrumentista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        instrumentistaService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}