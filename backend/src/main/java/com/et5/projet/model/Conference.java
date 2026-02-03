package com.et5.projet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    @NotNull(message = "La date est obligatoire")
    @Future(message = "La conférence doit avoir lieu dans le futur") // Validation utile !
    private LocalDateTime date;

    @NotBlank(message = "Le lieu est obligatoire")
    private String location;

    // Relation Many-to-Many : Une conf a plusieurs speakers
    @ManyToMany
    @JoinTable(
            name = "conference_speakers", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;
}