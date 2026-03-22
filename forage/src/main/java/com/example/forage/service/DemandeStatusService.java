package com.example.forage.service;
import com.example.forage.model.Demande;
import com.example.forage.model.DemandeStatus;
import com.example.forage.repository.DemandeStatusRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DemandeStatusService {

    private final DemandeStatusRepository repository;

    public DemandeStatusService(DemandeStatusRepository repository) {
        this.repository = repository;
    }

    public List<DemandeStatus> findAll() {
        return repository.findAll();
    }

    public DemandeStatus findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DemandeStatus save(DemandeStatus demandeStatus) {
        return repository.save(demandeStatus);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Retourne l'historique complet des statuts d'une demande, du plus recent au plus ancien
    public List<DemandeStatus> getHistorique(Demande demande) {
        return repository.findByDemandeOrderByDateDesc(demande);
    }

    // Retourne le statut actuel = le premier element de la liste triee par date DESC
    public DemandeStatus getStatusActuel(Demande demande) {
        List<DemandeStatus> historique = getHistorique(demande);
        // si la liste est vide, la demande n'a pas encore de statut
        return historique.isEmpty() ? null : historique.get(0);
    }
}
