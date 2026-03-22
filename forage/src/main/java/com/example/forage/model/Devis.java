package com.example.forage.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_devis")
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devis")
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_type_devis")
    private TypeDevis typeDevis;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    @OneToMany(mappedBy = "devis")
    private List<DetailDevis> detailDevis;

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
    public TypeDevis getTypeDevis() { 
        return typeDevis; 
    }
    public void setTypeDevis(TypeDevis typeDevis) { 
        this.typeDevis = typeDevis; 
    }
    public Demande getDemande() { 
        return demande; 
    }
    public void setDemande(Demande demande) { 
        this.demande = demande; 
    }
    public List<DetailDevis> getDetailDevis() { 
        return detailDevis; 
    }
    public void setDetailDevis(List<DetailDevis> detailDevis) { 
        this.detailDevis = detailDevis; 
    }
}