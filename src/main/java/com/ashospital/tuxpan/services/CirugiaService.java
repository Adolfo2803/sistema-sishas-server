package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.ApoyoExterno;
import com.ashospital.tuxpan.models.Cirugia;
import com.ashospital.tuxpan.models.Interno;
import com.ashospital.tuxpan.models.Residente;
import com.ashospital.tuxpan.repositories.CirugiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;


    @Service
    @Transactional
    public class CirugiaService {

        @Autowired
        private CirugiaRepository cirugiaRepository;

        // Crear una nueva cirugía
        public Cirugia createCirugia(Cirugia cirugia) {
            // Validar que no exista el número de cirugía
            if (cirugiaRepository.existsByNumeroCirugia(cirugia.getNumeroCirugia())) {
                throw new RuntimeException("Ya existe una cirugía con el número: " + cirugia.getNumeroCirugia());
            }

            // Establecer fechas de creación y actualización
            cirugia.setCreatedAt(LocalDateTime.now());
            cirugia.setUpdatedAt(LocalDateTime.now());

            return cirugiaRepository.save(cirugia);
        }

        // Actualizar una cirugía existente
        public Cirugia updateCirugia(Long id, Cirugia cirugiaDetails) {
            Cirugia cirugia = getCirugiaById(id);

            // Actualizar campos
            cirugia.setNumeroQuirofano(cirugiaDetails.getNumeroQuirofano());
            cirugia.setFechaCirugia(cirugiaDetails.getFechaCirugia());
            cirugia.setIniciaAnestesia(cirugiaDetails.getIniciaAnestesia());
            cirugia.setTerminaAnestesia(cirugiaDetails.getTerminaAnestesia());
            cirugia.setMaterial(cirugiaDetails.getMaterial());
            cirugia.setMedicamento(cirugiaDetails.getMedicamento());
            cirugia.setSuturas(cirugiaDetails.getSuturas());
            cirugia.setPaciente(cirugiaDetails.getPaciente());
            cirugia.setCirujano(cirugiaDetails.getCirujano());
            cirugia.setAnestesiologo(cirugiaDetails.getAnestesiologo());
            cirugia.setInstrumentista(cirugiaDetails.getInstrumentista());
            cirugia.setCirculante(cirugiaDetails.getCirculante());
            cirugia.setResidentes(cirugiaDetails.getResidentes());
            cirugia.setInternos(cirugiaDetails.getInternos());
            cirugia.setApoyoExterno(cirugiaDetails.getApoyoExterno());
            cirugia.setTipoCirugia(cirugiaDetails.getTipoCirugia());

            cirugia.setUpdatedAt(LocalDateTime.now());

            return cirugiaRepository.save(cirugia);
        }

        // Obtener todas las cirugías
        public List<Cirugia> getAllCirugias() {
            return cirugiaRepository.findAll();
        }

        // Obtener cirugía por ID
        public Cirugia getCirugiaById(Long id) {
            return cirugiaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró la cirugía con ID: " + id));
        }

        // Buscar por número de cirugía
        public Optional<Cirugia> getCirugiaByNumero(String numeroCirugia) {
            return cirugiaRepository.findByNumeroCirugia(numeroCirugia);
        }

        // Obtener cirugías por fecha
        public List<Cirugia> getCirugiasByFecha(LocalDate fecha) {
            return cirugiaRepository.findByFechaCirugia(fecha);
        }

        // Obtener cirugías por rango de fechas
        public List<Cirugia> getCirugiasBetweenFechas(LocalDate fechaInicio, LocalDate fechaFin) {
            return cirugiaRepository.findByFechaCirugiaBetween(fechaInicio, fechaFin);
        }

        // Obtener cirugías por quirófano
        public List<Cirugia> getCirugiasByQuirofano(Integer numeroQuirofano) {
            return cirugiaRepository.findByNumeroQuirofano(numeroQuirofano);
        }

        // Obtener cirugías por cirujano
        public List<Cirugia> getCirugiasByCirujano(Long cirujanoId) {
            return cirugiaRepository.findByCirujanoId(cirujanoId);
        }

        // Obtener cirugías por anestesiólogo
        public List<Cirugia> getCirugiasByAnestesiologo(Long anestesiologoId) {
            return cirugiaRepository.findByAnestesiologoId(anestesiologoId);
        }

        // Agregar residentes a una cirugía
        public Cirugia addResidentesToCirugia(Long cirugiaId, Set<Residente> residentes) {
            Cirugia cirugia = getCirugiaById(cirugiaId);
            cirugia.getResidentes().addAll(residentes);
            cirugia.setUpdatedAt(LocalDateTime.now());
            return cirugiaRepository.save(cirugia);
        }

        // Agregar internos a una cirugía
        public Cirugia addInternosToCirugia(Long cirugiaId, Set<Interno> internos) {
            Cirugia cirugia = getCirugiaById(cirugiaId);
            cirugia.getInternos().addAll(internos);
            cirugia.setUpdatedAt(LocalDateTime.now());
            return cirugiaRepository.save(cirugia);
        }

        // Agregar apoyo externo a una cirugía
        public Cirugia addApoyoExternoToCirugia(Long cirugiaId, Set<ApoyoExterno> apoyoExterno) {
            Cirugia cirugia = getCirugiaById(cirugiaId);
            cirugia.getApoyoExterno().addAll(apoyoExterno);
            cirugia.setUpdatedAt(LocalDateTime.now());
            return cirugiaRepository.save(cirugia);
        }

        // Eliminar una cirugía
        public void deleteCirugia(Long id) {
            Cirugia cirugia = getCirugiaById(id);
            cirugiaRepository.delete(cirugia);
        }

        // Obtener cirugías por instrumentista
        public List<Cirugia> getCirugiasByInstrumentista(Long instrumentistaId) {
            return cirugiaRepository.findByInstrumentistaId(instrumentistaId);
        }

        // Obtener cirugías por circulante
        public List<Cirugia> getCirugiasByCirculante(Long circulanteId) {
            return cirugiaRepository.findByCirculanteId(circulanteId);
        }
}
