package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.ApoyoExterno;
import com.ashospital.tuxpan.services.ApoyoExternoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apoyo-externo")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class ApoyoExternoController {
    private final ApoyoExternoService apoyoExternoService;

    public ApoyoExternoController(ApoyoExternoService apoyoExternoService) {
        this.apoyoExternoService = apoyoExternoService;
    }

    @GetMapping
    public ResponseEntity<List<ApoyoExterno>> listarTodos() {
        return ResponseEntity.ok(apoyoExternoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoyoExterno> buscarPorId(@PathVariable Long id) {
        return apoyoExternoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApoyoExterno> crear(@Valid @RequestBody ApoyoExterno apoyoExterno) {
        return ResponseEntity.ok(apoyoExternoService.guardar(apoyoExterno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        apoyoExternoService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}