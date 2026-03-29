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

    @Column(name = "pu")
    private Double pu;

    @Column(name = "qte")
    private Integer qte;

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
    public Double getPu() { 
        return pu; 
    }
    public void setPu(Double pu) { 
        this.pu = pu; 
    }
    public Integer getQte() { 
        return qte; 
    }
    public void setQte(Integer qte) { 
        this.qte = qte; 
    }
    public Devis getDevis() { 
        return devis; 
    }
    public void setDevis(Devis devis) { 
        this.devis = devis; 
    }
}