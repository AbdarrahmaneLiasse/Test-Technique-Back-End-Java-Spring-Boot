package com.example.gest_empl_depart.services.dto;

import com.example.gest_empl_depart.services.models.Departement;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Le nom ne peut pas etre vide")
    private String nom;
    @NotBlank(message = "Le prenom ne peut pas etre vide")
    private String prénom ;
    @NotBlank(message = "L'email ne peut pas etre vide")
    @Email(message = "Format d'Email invalide")
    private String email;
    private String poste;
    @Positive(message = "Le salaire doit etre positif")
    private Double salaire;
    private Integer département;
}
