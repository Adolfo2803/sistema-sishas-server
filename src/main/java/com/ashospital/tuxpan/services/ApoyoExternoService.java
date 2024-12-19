package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.ApoyoExterno;
import com.ashospital.tuxpan.repositories.ApoyoExternoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApoyoExternoService {

    private final ApoyoExternoRepository apoyoExternoRepository;

    public ApoyoExternoService(ApoyoExternoRepository apoyoExternoRepository) {
        this.apoyoExternoRepository = apoyoExternoRepository;
    }

    public List<ApoyoExterno> listarTodos() {
        return apoyoExternoRepository.findAll();
    }

    public Optional<ApoyoExterno> buscarPorId(Long id) {
        return apoyoExternoRepository.findById(id);
    }

    public ApoyoExterno guardar(ApoyoExterno apoyoExterno) {
        apoyoExterno.setCreatedAt(LocalDateTime.now());
        return apoyoExternoRepository.save(apoyoExterno);
    }

    public void eliminar(Long id) {
        apoyoExternoRepository.deleteById(id);
    }
}