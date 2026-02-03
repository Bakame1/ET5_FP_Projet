package com.et5.projet.service;

import com.et5.projet.model.Conference;
import com.et5.projet.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
* Le Controller ne doit jamais parler directement à la Base de données .
* Il doit passer par le Service qui contient la logique.
* */

@Service
@RequiredArgsConstructor
public class ConferenceService {

    private final ConferenceRepository repository;

    public List<Conference> getAll() {
        return repository.findAll();
    }

    public List<Conference> getFutureConferences() {
        return repository.findByDateAfter(LocalDateTime.now());
    }

    public Conference getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conférence introuvable avec l'ID : " + id));
    }

    public Conference save(Conference conference) {
        return repository.save(conference);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}