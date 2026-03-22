package com.example.forage.service;

import com.example.forage.model.Demande;
import com.example.forage.repository.DemandeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeService {
    private final DemandeRepository repository;

    public DemandeService(DemandeRepository repository) {
        this.repository = repository;
    }

    public List<Demande> findAll() {
        return repository.findAll();
    }

    public Demande findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Demande save(Demande demande) {
        return repository.save(demande);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}