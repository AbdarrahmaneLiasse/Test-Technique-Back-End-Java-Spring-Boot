package com.example.gest_empl_depart.services.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prénom;
    @Column(unique=true)
    @Email(message = "Format d'Email invalide")
    private String email;
    private String poste;
    private double salaire;
    @ManyToOne
    @JoinColumn(name = "département")
    private Departement département;
}
