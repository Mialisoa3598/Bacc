package com.example.correction.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_note_finale")
public class NoteFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note_finale")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat candidat;

    @Column(name = "note_finale")
    private Double note;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public Matiere getMatiere() { 
        return matiere; 
    }
    public void setMatiere(Matiere matiere) { 
        this.matiere = matiere; 
    }
    public Candidat getCandidat() { 
        return candidat; 
    }
    public void setCandidat(Candidat candidat) { 
        this.candidat = candidat; 
    }
    public Double getNote() { 
        return note; 
    }
    public void setNote(Double note) { 
        this.note = note; 
    }
}
