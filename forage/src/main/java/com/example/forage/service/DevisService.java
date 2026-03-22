package com.example.forage.service;

import java.util.List;

import com.example.forage.model.Devis;
import com.example.forage.repository.DevisRepository;
import org.springframework.stereotype.Service;

@Service
public class DevisService {
    private final DevisRepository repository;

    public DevisService(DevisRepository repository) {
        this.repository = repository;
    }

    public List<Devis> findAll() {
        return repository.findAll();
    }

    public Devis findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Devis save(Devis devis) {
        return repository.save(devis);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
