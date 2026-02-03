package com.et5.projet.service;

import com.et5.projet.model.Speaker;
import com.et5.projet.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Le Controller ne doit jamais parler directement à la Base de données .
 * Il doit passer par le Service qui contient la logique.
 * */

@Service
@RequiredArgsConstructor // Génère le constructeur pour l'injection de dépendances (remplace @Autowired)
public class SpeakerService {

    private final SpeakerRepository repository;

    public List<Speaker> getAll() {
        return repository.findAll();
    }

    public Speaker getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Speaker introuvable avec l'ID : " + id));
    }

    public Speaker save(Speaker speaker) {
        return repository.save(speaker);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}