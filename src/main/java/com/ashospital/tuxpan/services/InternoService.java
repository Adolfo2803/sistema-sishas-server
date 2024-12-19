package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Interno;
import com.ashospital.tuxpan.repositories.InternoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InternoService {
    private final InternoRepository internoRepository;

    public InternoService(InternoRepository internoRepository) {
        this.internoRepository = internoRepository;
    }

    public List<Interno> listarTodos() {
        return internoRepository.findAll();
    }

    public Optional<Interno> buscarPorId(Long id) {
        return internoRepository.findById(id);
    }

    public Interno guardar(Interno interno) {
        interno.setCreatedAt(LocalDateTime.now());
        return internoRepository.save(interno);
    }

    public void eliminar(Long id) {
        internoRepository.deleteById(id);
    }
}