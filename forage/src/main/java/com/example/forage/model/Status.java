package com.example.forage.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "status")
    private List<DemandeStatus> demandeStatuses;

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
    public List<DemandeStatus> getDemandeStatuses() { 
        return demandeStatuses; 
    }
    public void setDemandeStatuses(List<DemandeStatus> demandeStatuses) { 
        this.demandeStatuses = demandeStatuses; 
    }
}