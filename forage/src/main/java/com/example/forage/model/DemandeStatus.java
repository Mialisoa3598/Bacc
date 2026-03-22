package com.example.forage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_demande_status")
public class DemandeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande_status")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    private LocalDate date;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public Demande getDemande() { 
        return demande; 
    }
    public void setDemande(Demande demande) { 
        this.demande = demande; 
    }
    public Status getStatus() { 
        return status; 
    }
    public void setStatus(Status status) { 
        this.status = status; 
    }
    public LocalDate getDate() { 
        return date; 
    }
    public void setDate(LocalDate date) { 
        this.date = date; 
    }
}