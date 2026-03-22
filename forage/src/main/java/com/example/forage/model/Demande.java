package com.example.forage.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demande")
    private Long id;

    private LocalDate date;
    private String lieu;
    private String district;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany(mappedBy = "demande")
    private List<Devis> devis;

    @OneToMany(mappedBy = "demande")
    private List<DemandeStatus> demandeStatuses;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public LocalDate getDate() { 
        return date; 
    }
    public void setDate(LocalDate date) { 
        this.date = date; 
    }
    public String getLieu() { 
        return lieu; 
    }
    public void setLieu(String lieu) { 
        this.lieu = lieu; 
    }
    public String getDistrict() { 
        return district; 
    }
    public void setDistrict(String district) { 
        this.district = district; 
    }
    public Client getClient() { 
        return client; 
    }
    public void setClient(Client client) { 
        this.client = client; 
    }
    public List<Devis> getDevis() { 
        return devis; 
    }
    public void setDevis(List<Devis> devis) { 
        this.devis = devis; 
    }
    public List<DemandeStatus> getDemandeStatuses() { return demandeStatuses; }
    public void setDemandeStatuses(List<DemandeStatus> demandeStatuses) { this.demandeStatuses = demandeStatuses; }
}