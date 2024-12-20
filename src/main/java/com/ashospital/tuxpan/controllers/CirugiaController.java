package com.ashospital.tuxpan.controllers;

import com.ashospital.tuxpan.models.ApoyoExterno;
import com.ashospital.tuxpan.models.Cirugia;
import com.ashospital.tuxpan.models.Interno;
import com.ashospital.tuxpan.models.Residente;
import com.ashospital.tuxpan.services.CirugiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/cirugias")
@CrossOrigin(origins = "http://localhost:4200")
public class CirugiaController {

    @Autowired
    private CirugiaService cirugiaService;

    // Crear una nueva cirugía
    @PostMapping
    public ResponseEntity<Cirugia> createCirugia(@RequestBody Cirugia cirugia) {
        return new ResponseEntity<>(cirugiaService.createCirugia(cirugia), HttpStatus.CREATED);
    }

    // Actualizar una cirugía
    @PutMapping("/{id}")
    public ResponseEntity<Cirugia> updateCirugia(@PathVariable Long id, @RequestBody Cirugia cirugiaDetails) {
        return ResponseEntity.ok(cirugiaService.updateCirugia(id, cirugiaDetails));
    }

    // Obtener todas las cirugías
    @GetMapping
    public ResponseEntity<List<Cirugia>> getAllCirugias() {
        return ResponseEntity.ok(cirugiaService.getAllCirugias());
    }

    // Obtener cirugía por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cirugia> getCirugiaById(@PathVariable Long id) {
        return ResponseEntity.ok(cirugiaService.getCirugiaById(id));
    }

    // Buscar por número de cirugía
    @GetMapping("/numero/{numeroCirugia}")
    public ResponseEntity<?> getCirugiaByNumero(@PathVariable String numeroCirugia) {
        return cirugiaService.getCirugiaByNumero(numeroCirugia)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener cirugías por fecha
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Cirugia>> getCirugiasByFecha(@PathVariable LocalDate fecha) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByFecha(fecha));
    }

    // Obtener cirugías por rango de fechas
    @GetMapping("/fecha-range")
    public ResponseEntity<List<Cirugia>> getCirugiasBetweenFechas(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {
        return ResponseEntity.ok(cirugiaService.getCirugiasBetweenFechas(fechaInicio, fechaFin));
    }

    // Obtener cirugías por quirófano
    @GetMapping("/quirofano/{numeroQuirofano}")
    public ResponseEntity<List<Cirugia>> getCirugiasByQuirofano(@PathVariable Integer numeroQuirofano) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByQuirofano(numeroQuirofano));
    }

    // Obtener cirugías por cirujano
    @GetMapping("/cirujano/{cirujanoId}")
    public ResponseEntity<List<Cirugia>> getCirugiasByCirujano(@PathVariable Long cirujanoId) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByCirujano(cirujanoId));
    }

    // Obtener cirugías por anestesiólogo
    @GetMapping("/anestesiologo/{anestesiologoId}")
    public ResponseEntity<List<Cirugia>> getCirugiasByAnestesiologo(@PathVariable Long anestesiologoId) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByAnestesiologo(anestesiologoId));
    }

    // Agregar residentes a una cirugía
    @PostMapping("/{cirugiaId}/residentes")
    public ResponseEntity<Cirugia> addResidentesToCirugia(
            @PathVariable Long cirugiaId,
            @RequestBody Set<Residente> residentes) {
        return ResponseEntity.ok(cirugiaService.addResidentesToCirugia(cirugiaId, residentes));
    }

    // Agregar internos a una cirugía
    @PostMapping("/{cirugiaId}/internos")
    public ResponseEntity<Cirugia> addInternosToCirugia(
            @PathVariable Long cirugiaId,
            @RequestBody Set<Interno> internos) {
        return ResponseEntity.ok(cirugiaService.addInternosToCirugia(cirugiaId, internos));
    }

    // Agregar apoyo externo a una cirugía
    @PostMapping("/{cirugiaId}/apoyo-externo")
    public ResponseEntity<Cirugia> addApoyoExternoToCirugia(
            @PathVariable Long cirugiaId,
            @RequestBody Set<ApoyoExterno> apoyoExterno) {
        return ResponseEntity.ok(cirugiaService.addApoyoExternoToCirugia(cirugiaId, apoyoExterno));
    }

    // Eliminar una cirugía
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCirugia(@PathVariable Long id) {
        cirugiaService.deleteCirugia(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener cirugías por instrumentista
    @GetMapping("/instrumentista/{instrumentistaId}")
    public ResponseEntity<List<Cirugia>> getCirugiasByInstrumentista(@PathVariable Long instrumentistaId) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByInstrumentista(instrumentistaId));
    }

    // Obtener cirugías por circulante
    @GetMapping("/circulante/{circulanteId}")
    public ResponseEntity<List<Cirugia>> getCirugiasByCirculante(@PathVariable Long circulanteId) {
        return ResponseEntity.ok(cirugiaService.getCirugiasByCirculante(circulanteId));
    }
}
