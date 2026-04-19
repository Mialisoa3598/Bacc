package com.example.forage.model;

import jakarta.persistence.*;
// import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_demande_status")
public class DemandeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande_status")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    private LocalDateTime date;

        @Column(name = "observation")
        private String observation;

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
    public LocalDateTime getDate() { 
        return date; 
    }
    public void setDate(LocalDateTime date) { 
        this.date = date; 
    }

        public String getObservation() { 
            return observation; 
        }
        public void setObservation(String observation) { 
            this.observation = observation; 
        }
}