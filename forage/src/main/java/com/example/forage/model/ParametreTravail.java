package com.example.forage.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "t_parametre_travail")
public class ParametreTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heure_debut")
    private LocalTime heureDebut;

    @Column(name = "heure_fin")
    private LocalTime heureFin;

    @Column(name = "travail_samedi")
    private Boolean travailSamedi;

    @Column(name = "travail_dimanche")
    private Boolean travailDimanche;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }
    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }
    public Boolean getTravailSamedi() { return travailSamedi; }
    public void setTravailSamedi(Boolean travailSamedi) { this.travailSamedi = travailSamedi; }
    public Boolean getTravailDimanche() { return travailDimanche; }
    public void setTravailDimanche(Boolean travailDimanche) { this.travailDimanche = travailDimanche; }
}