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
    private final DetailDevisRepository detailDevisRepository;

    public DevisService(DevisRepository repository,
                        DemandeStatusRepository demandeStatusRepository,
                        StatusRepository statusRepository,
                        DetailDevisRepository detailDevisRepository) {
        this.repository = repository;
        this.demandeStatusRepository = demandeStatusRepository;
        this.statusRepository = statusRepository;

        this.detailDevisRepository = detailDevisRepository;
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
    public Devis update(Devis devis) {
        Devis saveDevis = repository.save(devis);
        return saveDevis;
    }

    @Transactional
    public Devis createDevis(Devis devis, List<DetailDevis> details) {
        Devis saveDevis = repository.save(devis);
        for (DetailDevis detail : details) {
            detail.setDevis(saveDevis);
            detailDevisRepository.save(detail);
        }

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