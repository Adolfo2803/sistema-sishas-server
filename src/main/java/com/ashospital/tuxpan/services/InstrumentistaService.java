package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Instrumentista;
import com.ashospital.tuxpan.repositories.InstrumentistaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InstrumentistaService {

    private final InstrumentistaRepository instrumentistaRepository;

    public InstrumentistaService(InstrumentistaRepository instrumentistaRepository) {
        this.instrumentistaRepository = instrumentistaRepository;
    }

    public List<Instrumentista> listarTodos() {
        return instrumentistaRepository.findAll();
    }

    public Optional<Instrumentista> buscarPorId(Long id) {
        return instrumentistaRepository.findById(id);
    }

    public Instrumentista guardar(Instrumentista instrumentista) {
        instrumentista.setCreatedAt(LocalDateTime.now());
        return instrumentistaRepository.save(instrumentista);
    }

    public void eliminar(Long id) {
        instrumentistaRepository.deleteById(id);
    }
}