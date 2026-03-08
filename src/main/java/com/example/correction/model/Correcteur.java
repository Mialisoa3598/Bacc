package com.example.correction.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_correcteur")
public class Correcteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_correcteur")
    private Long id;

    private String nom;

    // Getters & Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public String getNom() { 
        return nom; 
    }
    public void setNom(String nom) { 
        this.nom = nom; 
    }
}
