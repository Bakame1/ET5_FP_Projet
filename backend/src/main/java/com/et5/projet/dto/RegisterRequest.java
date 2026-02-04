package com.et5.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Ce que le user envoie pour s'inscrire
* */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email; // On utilise bien email (comme validé ensemble)
    private String password;
}