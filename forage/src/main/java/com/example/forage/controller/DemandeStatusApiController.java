package com.example.forage.controller;

import com.example.forage.model.DemandeStatus;
import com.example.forage.service.DemandeStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/demande-status")
public class DemandeStatusApiController {

    private final DemandeStatusService demandeStatusService;

    public DemandeStatusApiController(DemandeStatusService demandeStatusService) {
        this.demandeStatusService = demandeStatusService;
    }

    // Retourne l'historique d'une demande en JSON pour l'AJAX
    @GetMapping("/{idDemande}")
    public List<DemandeStatus> getHistorique(@PathVariable Long idDemande) {
        return demandeStatusService.getHistoriqueByIdDemande(idDemande);
    }
}