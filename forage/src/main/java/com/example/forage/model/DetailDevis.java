package com.example.forage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_detail_devis")
public class DetailDevis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_devis")
    private Long id;

    private String libelle;
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "id_devis")
    private Devis devis;

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
    public Double getMontant() { 
        return montant; 
    }
    public void setMontant(Double montant) { 
        this.montant = montant; 
    }
    public Devis getDevis() { 
        return devis; 
    }
    public void setDevis(Devis devis) { 
        this.devis = devis; 
    }
}