package com.example.forage.service;

import com.example.forage.model.Demande;
import com.example.forage.model.DemandeStatus;
import com.example.forage.model.Status;
import com.example.forage.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DemandeService {
    private final DemandeRepository repository;
    private final DemandeStatusRepository demandeStatusRepository;
    private final StatusRepository statusRepository;

    public DemandeService(DemandeRepository repository,
                          DemandeStatusRepository demandeStatusRepository,
                          StatusRepository statusRepository) {
        this.repository = repository;
        this.demandeStatusRepository = demandeStatusRepository;
        this.statusRepository = statusRepository;
    }

    public List<Demande> findAll() { 
        return repository.findAll(); 
    }
    public Demande findById(Long id) { 
        return repository.findById(id).orElse(null); 
    }
    public void delete(Long id) { 
        repository.deleteById(id); 
    }
    public Demande update(Demande demande) {
        Demande saveDemande = repository.save(demande);
        return saveDemande;
    }

    @Transactional
    public Demande createDemande(Demande demande) {

        Demande saveDemande = repository.save(demande);

        Status statusCree = statusRepository.findByLibelleIgnoreCase("cree")
                                .orElseThrow(() -> new RuntimeException("Status 'cree' introuvable en base"));

        DemandeStatus demandeStatus = new DemandeStatus();
        demandeStatus.setDemande(saveDemande);
        demandeStatus.setStatus(statusCree);
        demandeStatus.setDate(LocalDate.now());
        demandeStatusRepository.save(demandeStatus);

        return saveDemande;
    }
}