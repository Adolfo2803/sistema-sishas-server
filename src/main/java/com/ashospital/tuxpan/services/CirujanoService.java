package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Cirujano;
import com.ashospital.tuxpan.repositories.CirujanoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CirujanoService {

    private final CirujanoRepository cirujanoRepository;

    public CirujanoService(CirujanoRepository cirujanoRepository) {
        this.cirujanoRepository = cirujanoRepository;
    }

    public List<Cirujano> listarTodos() {
        return cirujanoRepository.findAll();
    }

    public Optional<Cirujano> buscarPorId(Long id) {
        return cirujanoRepository.findById(id);
    }

    public Cirujano guardar(Cirujano cirujano) {
        cirujano.setCreatedAt(LocalDateTime.now());
        return cirujanoRepository.save(cirujano);
    }

    public void eliminar(Long id) {
        cirujanoRepository.deleteById(id);
    }
}
