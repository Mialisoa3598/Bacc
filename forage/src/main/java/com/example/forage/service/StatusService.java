package com.example.forage.service;

import com.example.forage.model.Status;
import com.example.forage.repository.StatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusService {

    private final StatusRepository repository;
    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    public List<Status> findAll() { 
        return repository.findAll(); 
    }

    public Status findById(Long id) { 
        return repository.findById(id).orElse(null); 
    }

    public Status save(Status status) { 
        return repository.save(status); 
    }

    public void delete(Long id) { 
        repository.deleteById(id); 
    }
}