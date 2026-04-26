package com.example.forage.controller;

import com.example.forage.model.DemandeStatus;
import com.example.forage.service.DemandeStatusService;
import com.example.forage.service.DureeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demande-status")
public class DemandeStatusApiController {

    private final DemandeStatusService demandeStatusService;
    private final DureeService dureeService;

    public DemandeStatusApiController(DemandeStatusService demandeStatusService, DureeService dureeService) {
        this.demandeStatusService = demandeStatusService;
        this.dureeService = dureeService;
    }

    // Retourne l'historique d'une demande en JSON pour l'AJAX
    // @GetMapping("/{idDemande}")
    // public List<DemandeStatus> getHistorique(@PathVariable Long idDemande) {
    //     return demandeStatusService.getHistoriqueByIdDemande(idDemande);
    // }

            @GetMapping("/{idDemande}")
            public List<Map<String, Object>> getHistorique(@PathVariable Long idDemande) {
                List<DemandeStatus> historique = demandeStatusService.getHistoriqueByIdDemande(idDemande);
                List<Map<String, Object>> result = new ArrayList<>();
                for (DemandeStatus ds : historique) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", ds.getId());
                    map.put("date", ds.getDate());
                    map.put("observation", ds.getObservation());
                    map.put("status", ds.getStatus());
                    map.put("dureeSimpleFormatted", dureeService.formatterDuree(ds.getDureeSimple()));
                    map.put("dureeComplexeFormatted", dureeService.formatterDuree(ds.getDureeComplexe()));
                    result.add(map);
                }
                return result;
            }
}