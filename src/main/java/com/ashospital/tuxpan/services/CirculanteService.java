package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Circulante;
import com.ashospital.tuxpan.repositories.CirculanteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CirculanteService {

    private final CirculanteRepository circulanteRepository;

    public CirculanteService(CirculanteRepository circulanteRepository) {
        this.circulanteRepository = circulanteRepository;
    }

    public List<Circulante> listarTodos() {
        return circulanteRepository.findAll();
    }

    public Optional<Circulante> buscarPorId(Long id) {
        return circulanteRepository.findById(id);
    }

    public Circulante guardar(Circulante circulante) {
        circulante.setCreatedAt(LocalDateTime.now());
        return circulanteRepository.save(circulante);
    }



    public void eliminar(Long id) {
        circulanteRepository.deleteById(id);
    }
}
