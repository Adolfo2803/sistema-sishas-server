package com.ashospital.tuxpan.services;

import com.ashospital.tuxpan.models.Anestesiologo;
import com.ashospital.tuxpan.models.Interno;
import com.ashospital.tuxpan.repositories.AnestesiologoRepository;
import com.ashospital.tuxpan.repositories.InternoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnestesiologoService {

    private final AnestesiologoRepository anestesiologoRepository;

    public AnestesiologoService(AnestesiologoRepository anestesiologoRepository) {
        this.anestesiologoRepository = anestesiologoRepository;
    }

    public List<Anestesiologo> listarTodos() {
        return anestesiologoRepository.findAll();
    }

    public Optional<Anestesiologo> buscarPorId(Long id) {
        return anestesiologoRepository.findById(id);
    }

    public Anestesiologo guardar(Anestesiologo interno) {
        interno.setCreatedAt(LocalDateTime.now());
        return anestesiologoRepository.save(interno);
    }

    public void eliminar(Long id) {
        anestesiologoRepository.deleteById(id);
    }
}
