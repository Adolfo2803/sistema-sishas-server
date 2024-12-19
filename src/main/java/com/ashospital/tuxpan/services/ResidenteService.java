package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Residente;
import com.ashospital.tuxpan.repositories.ResidenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResidenteService {

    private final ResidenteRepository residenteRepository;

    public ResidenteService(ResidenteRepository residenteRepository) {
        this.residenteRepository = residenteRepository;
    }

    public List<Residente> listarTodos() {
        return residenteRepository.findAll();
    }

    public Optional<Residente> buscarPorId(Long id) {
        return residenteRepository.findById(id);
    }

    public Residente guardar(Residente residente) {
        residente.setCreatedAt(LocalDateTime.now());
        return residenteRepository.save(residente);
    }

    public void eliminar(Long id) {
        residenteRepository.deleteById(id);
    }
}