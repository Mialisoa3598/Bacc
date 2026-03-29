package com.example.forage.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    private String nom;
    private String contact;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Demande> demandes;

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
    public String getContact() { 
        return contact; 
    }
    public void setContact(String contact) { 
        this.contact = contact; 
    }
    public List<Demande> getDemandes() { 
        return demandes; 
    }
    public void setDemandes(List<Demande> demandes) { 
        this.demandes = demandes; 
    }
}