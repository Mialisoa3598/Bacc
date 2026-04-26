package com.example.forage.service;
import com.example.forage.model.Demande;
import com.example.forage.model.DemandeStatus;
import com.example.forage.repository.DemandeStatusRepository;

// import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DemandeStatusService {

    private final DemandeStatusRepository repository;
    private final DureeService dureeService;

    public DemandeStatusService(DemandeStatusRepository repository, DureeService dureeService) {
        this.repository = repository;
        this.dureeService = dureeService;

    }

    public List<DemandeStatus> findAll() {
        return repository.findAll();
    }

    public DemandeStatus findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // public DemandeStatus save(DemandeStatus demandeStatus) {
    //     return repository.save(demandeStatus);
    // }

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

        // public DemandeStatus update(Integer id, String observation, String date) {
        //     DemandeStatus ds = repository.findById(id.longValue()).orElse(null);
        //     ds.setObservation(observation);
        //     ds.setDate(LocalDateTime.parse(date));
        //     return repository.save(ds);
        // }
        public List<DemandeStatus> getHistoriqueByIdDemande(Long idDemande) {
            Demande demande = new Demande();
            demande.setId(idDemande);
            return repository.findByDemandeOrderByDateDesc(demande);
        }

                public List<Demande> getDemandesByStatus(Long idStatus) {
                    return repository.findAll().stream()
                            .filter(ds -> ds.getStatus().getId().equals(idStatus))
                            .map(ds -> ds.getDemande())
                            .distinct()
                            .collect(java.util.stream.Collectors.toList());
                }

                            public DemandeStatus save(DemandeStatus demandeStatus) {
                                // Recuperer le status precedent de la meme demande
                                List<DemandeStatus> historique = repository
                                        .findByDemandeOrderByDateDesc(demandeStatus.getDemande());

                                if (!historique.isEmpty()) {
                                    // Le plus recent est le premier car tri DESC
                                    DemandeStatus precedent = historique.get(0);
                                    LocalDateTime datePrecedent = precedent.getDate();
                                    LocalDateTime dateCourant = demandeStatus.getDate();

                                    // Calculer duree simple
                                    Integer dureeSimple = dureeService.calculerDureeSimple(datePrecedent, dateCourant);
                                    demandeStatus.setDureeSimple(dureeSimple);

                                    // Calculer duree complexe
                                    Integer dureeComplexe = dureeService.calculerDureeComplexe(datePrecedent, dateCourant);
                                    demandeStatus.setDureeComplexe(dureeComplexe);
                                } else {
                                    // Premier status — pas de duree
                                    demandeStatus.setDureeSimple(null);
                                    demandeStatus.setDureeComplexe(null);
                                }

                                return repository.save(demandeStatus);
                            }

                            // public DemandeStatus update(Integer id, String observation, String date) {
                            //     DemandeStatus ds = repository.findById(id.longValue()).orElse(null);
                            //     ds.setObservation(observation);
                            //     ds.setDate(java.time.LocalDateTime.parse(date,
                            //             java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
                            //     return repository.save(ds);
                            // }
                            public DemandeStatus update(Integer id, String observation, String date) {
                                DemandeStatus ds = repository.findById(id.longValue()).orElse(null);
                                ds.setObservation(observation);
                                ds.setDate(LocalDateTime.parse(date,
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));

                                // Recuperer tout l'historique de la demande trie ASC
                                List<DemandeStatus> historique = repository
                                        .findByDemandeOrderByDateDesc(ds.getDemande());
                                // Inverser pour avoir ASC
                                java.util.Collections.reverse(historique);

                                // Trouver la position du status modifie
                                int index = -1;
                                for (int i = 0; i < historique.size(); i++) {
                                    if (historique.get(i).getId().equals(ds.getId())) {
                                        index = i;
                                        break;
                                    }
                                }

                                // Recalculer duree du status modifie par rapport au precedent
                                if (index > 0) {
                                    DemandeStatus precedent = historique.get(index - 1);
                                    ds.setDureeSimple(dureeService.calculerDureeSimple(
                                            precedent.getDate(), ds.getDate()));
                                    ds.setDureeComplexe(dureeService.calculerDureeComplexe(
                                            precedent.getDate(), ds.getDate()));
                                } else {
                                    // Premier status — pas de duree
                                    ds.setDureeSimple(null);
                                    ds.setDureeComplexe(null);
                                }

                                DemandeStatus saved = repository.save(ds);

                                // Recalculer aussi le status suivant car sa duree depend de la date modifiee
                                if (index >= 0 && index < historique.size() - 1) {
                                    DemandeStatus suivant = historique.get(index + 1);
                                    suivant.setDureeSimple(dureeService.calculerDureeSimple(
                                            ds.getDate(), suivant.getDate()));
                                    suivant.setDureeComplexe(dureeService.calculerDureeComplexe(
                                            ds.getDate(), suivant.getDate()));
                                    repository.save(suivant);
                                }

                                return saved;
                            }
}
