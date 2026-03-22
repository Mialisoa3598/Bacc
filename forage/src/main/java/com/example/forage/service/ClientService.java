package com.example.forage.service;

import com.example.forage.model.Client;
import com.example.forage.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAll() { 
        return repository.findAll(); 
    }

    public Client findById(Long id) { 
        return repository.findById(id).orElse(null); 
    }

    public Client save(Client client) { 
        return repository.save(client); 
    }

    public void delete(Long id) { 
        repository.deleteById(id); 
    }

}