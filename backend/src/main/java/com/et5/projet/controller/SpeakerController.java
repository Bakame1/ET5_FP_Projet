package com.et5.projet.controller;

import com.et5.projet.model.Speaker;
import com.et5.projet.service.SpeakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Nous exposont les méthodes de Services via des URLs Endpoints
 * ici nous allons renvoyer du JSON
 * */

@RestController // API REST => JSON
@RequestMapping("/api/speakers") // Préfixe commun à toutes les routes
@RequiredArgsConstructor
public class SpeakerController {

    private final SpeakerService service;

    // GET /api/speakers
    // Renvoie tous les speakers
    @GetMapping
    public List<Speaker> getAll() {
        return service.getAll();
    }

    // GET /api/speakers/{id}
    // Renvoie un speaker par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // POST /api/speakers
    // Crée un nouveau speaker
    @PostMapping
    public ResponseEntity<Speaker> create(@Valid @RequestBody Speaker speaker) {
        // @Valid active la vérification des contraintes (@NotBlank) définies dans l'entité
        Speaker saved = service.save(speaker);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // DELETE /api/speakers/{id}
    // Supprime un speaker par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Renvoie 204 (succes mais pas de contenu)
    }
}