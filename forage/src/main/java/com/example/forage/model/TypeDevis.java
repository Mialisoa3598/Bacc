package com.example.forage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_type_devis")
public class TypeDevis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_devis")
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "typeDevis")
    private List<Devis> devis;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public String getLibelle() { 
        return libelle; 
    }
    public void setLibelle(String libelle) { 
        this.libelle = libelle; 
    }
    public List<Devis> getDevis() { 
        return devis; 
    }
    public void setDevis(List<Devis> devis) { 
        this.devis = devis; 
    }
}