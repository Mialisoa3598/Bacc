package com.example.correction.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_operateur")
public class Operateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operateur")
    private Long id;

    private String operateur;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public String getOperateur() { 
        return operateur; 
    }
    public void setOperateur(String operateur) { 
        this.operateur = operateur; 
    }
}
