package com.example.correction.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat")
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "candidat")
    private List<Note> notes;

    @OneToMany(mappedBy = "candidat")
    private List<NoteFinal> notesFinals;

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
    public List<Note> getNotes() { 
        return notes; 
    }
    public void setNotes(List<Note> notes) { 
        this.notes = notes; 
    }
    public List<NoteFinal> getNotesFinals() { 
        return notesFinals; 
    }
    public void setNotesFinals(List<NoteFinal> notesFinals) { 
        this.notesFinals = notesFinals; 
    }
}