package com.et5.projet.repository;

import com.et5.projet.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    // Spring comprend le nom de la méthode et génère le SQL
    //Pour trouver les conferences futures
    List<Conference> findByDateAfter(LocalDateTime date);
}