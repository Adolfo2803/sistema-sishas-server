package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.Residente;
import com.ashospital.tuxpan.services.ResidenteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residentes")
@CrossOrigin(origins = "http://localhost:4200")
@PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
public class ResidenteController {
    private final ResidenteService residenteService;

    public ResidenteController(ResidenteService residenteService) {
        this.residenteService = residenteService;
    }

    @GetMapping
    public ResponseEntity<List<Residente>> listarTodos() {
        return ResponseEntity.ok(residenteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residente> buscarPorId(@PathVariable Long id) {
        return residenteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Residente> crear(@Valid @RequestBody Residente residente) {
        return ResponseEntity.ok(residenteService.guardar(residente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        residenteService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
