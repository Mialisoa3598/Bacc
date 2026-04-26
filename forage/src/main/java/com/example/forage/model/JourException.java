package com.example.forage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_jour_exception")
public class JourException {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_exception")
    private LocalDate dateException;

    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateException() { return dateException; }
    public void setDateException(LocalDate dateException) { this.dateException = dateException; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}