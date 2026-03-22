package com.example.forage.service;

import java.util.List;

import com.example.forage.model.TypeDevis;
import com.example.forage.repository.TypeDevisRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeDevisService {
    private final TypeDevisRepository repository;

    public TypeDevisService(TypeDevisRepository repository) {
        this.repository = repository;
    }

    public List<TypeDevis> findAll() {
        return repository.findAll();
    }

    public TypeDevis findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public TypeDevis save(TypeDevis typeDevis) {
        return repository.save(typeDevis);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
