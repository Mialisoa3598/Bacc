package com.example.forage.service;

import com.example.forage.model.*;
import com.example.forage.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DevisService {
    private final DevisRepository repository;
    private final DemandeStatusRepository demandeStatusRepository;
    private final StatusRepository statusRepository;

    public DevisService(DevisRepository repository,
                        DemandeStatusRepository demandeStatusRepository,
                        StatusRepository statusRepository) {
        this.repository = repository;
        this.demandeStatusRepository = demandeStatusRepository;
        this.statusRepository = statusRepository;
    }

    public List<Devis> findAll() { 
        return repository.findAll(); 
    }
    public Devis findById(Long id) { 
        return repository.findById(id).orElse(null); 
    }
    public void delete(Long id) { 
        repository.deleteById(id); 
    }

    @Transactional
    public Devis createDevis(Devis devis) {
        Devis saveDevis = repository.save(devis);

        String typeLibelle = saveDevis.getTypeDevis().getLibelle();
        String statusLibelle = "devis " + typeLibelle.toLowerCase() + " cree";

        Status status = statusRepository.findByLibelleIgnoreCase(statusLibelle)
                .orElseThrow(() -> new RuntimeException("Status '" + statusLibelle + "' n'est pas dans la base"));

        // String typeLibelle = saveDevis.getTypeDevis().getLibelle();
        // String statusLibelle = "Devis " + typeLibelle + "cree";

        // Status status = statusRepository.findByLibelleIgnoreCase(statusLibelle)
        //         .orElseThrow(() -> new RuntimeException("Status '" + statusLibelle + "' n'est pas dans la base"));

        DemandeStatus demandeStatus = new DemandeStatus();
        demandeStatus.setDemande(saveDevis.getDemande());
        demandeStatus.setStatus(status);
        demandeStatus.setDate(LocalDate.now());
        demandeStatusRepository.save(demandeStatus);

        return saveDevis;
    }
}