package com.et5.projet.controller;

import com.et5.projet.model.Conference;
import com.et5.projet.service.ConferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*
* Nous exposont les méthodes de Services via des URLs Endpoints
* ici nous allons renvoyer du JSON
* */

@RestController // API REST => JSON
@RequestMapping("/api/conferences")
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService service;

    // GET /api/conferences
    // Renvoie toutes les conférences
    @GetMapping
    public List<Conference> getAll() {
        return service.getAll();
    }

    // GET /api/conferences/future
    // Renvoie les conférences futures
    @GetMapping("/future")
    public List<Conference> getFuture() {
        return service.getFutureConferences();
    }

    // GET /api/conferences/{id}
    // Renvoie une conférence par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Conference> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // POST /api/conferences
    // Crée une nouvelle conférence
    @PostMapping
    public ResponseEntity<Conference> create(@Valid @RequestBody Conference conference) {
        Conference saved = service.save(conference);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // DELETE /api/conferences/{id}
    // Supprime une conférence par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}