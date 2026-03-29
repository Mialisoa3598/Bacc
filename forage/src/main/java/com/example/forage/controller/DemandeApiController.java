package com.example.forage.controller;

import com.example.forage.model.Demande;
import com.example.forage.service.DemandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demandes")
public class DemandeApiController {

    private final DemandeService demandeService;

    public DemandeApiController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/{id}")
    public Demande getInfoDemande(@PathVariable Long id) {
        return demandeService.findById(id);
    }
}