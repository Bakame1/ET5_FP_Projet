package com.et5.projet.repository;

import com.et5.projet.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Spring Data JPA : Au lieu d'écrire des requêtes SQL, nous allons simplement créer des interfaces.
*  Spring va générer le code d'accès à la base de données automatiquement au démarrage
* */


@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    // CRUD deja existant
    //CRUD = 4 opérations fondamentales sur les donnees : Create, Read, Update, Delete
}