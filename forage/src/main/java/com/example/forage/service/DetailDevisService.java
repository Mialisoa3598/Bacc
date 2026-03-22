package com.example.forage.service;
import com.example.forage.model.DetailDevis;
import com.example.forage.repository.DetailDevisRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DetailDevisService {
    private final DetailDevisRepository repository;

    public DetailDevisService(DetailDevisRepository repository) {
        this.repository = repository;
    }

    public List<DetailDevis> findAll() {
        return repository.findAll();
    }

    public DetailDevis findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DetailDevis save(DetailDevis detailDevis) {
        return repository.save(detailDevis);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
