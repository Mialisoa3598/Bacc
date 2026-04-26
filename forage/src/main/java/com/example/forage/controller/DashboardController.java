package com.example.forage.controller;

import com.example.forage.model.Devis;
import com.example.forage.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final ClientService clientService;
    private final DevisService devisService;
    private final DetailDevisService detailDevisService;
    private final StatusService statusService;
    private final DemandeService demandeService;
    private final DemandeStatusService demandeStatusService;

    public DashboardController(ClientService clientService,
                               DevisService devisService,
                               DetailDevisService detailDevisService,
                               StatusService statusService,
                               DemandeService demandeService,
                               DemandeStatusService demandeStatusService) {
        this.clientService = clientService;
        this.devisService = devisService;
        this.detailDevisService = detailDevisService;
        this.statusService = statusService;
        this.demandeService = demandeService;
        this.demandeStatusService = demandeStatusService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("dashboard/index");

        // Nombre total de clients
        mav.addObject("nbClients", clientService.findAll().size());

        // Nombre total de devis
        mav.addObject("nbDevis", devisService.findAll().size());

        // Chiffre d'affaire = somme de tous pu * qte
        double ca = detailDevisService.findAll().stream()
                .mapToDouble(dd -> dd.getPu() * dd.getQte())
                .sum();
        mav.addObject("chiffreAffaire", ca);

        // Statistiques par status
        mav.addObject("statuts", statusService.findAll());
        mav.addObject("demandeStatuts", demandeStatusService.findAll());

        return mav;
    }

            // Liste des demandes par status
            @GetMapping("/status/{idStatus}")
            public ModelAndView demandesByStatus(@PathVariable Long idStatus) {
                ModelAndView mav = new ModelAndView("dashboard/status/list");
                mav.addObject("status", statusService.findById(idStatus));
                mav.addObject("demandes", demandeStatusService.getDemandesByStatus(idStatus));
                return mav;
            }

            // Liste tous les clients
            @GetMapping("/clients")
            public ModelAndView clients() {
                ModelAndView mav = new ModelAndView("dashboard/clients/list");
                mav.addObject("clients", clientService.findAll());
                return mav;
            }

            // Detail d'un client + ses demandes
            @GetMapping("/clients/{id}")
            public ModelAndView clientDetail(@PathVariable Long id) {
                ModelAndView mav = new ModelAndView("dashboard/clients/detail");
                mav.addObject("client", clientService.findById(id));
                mav.addObject("demandes", demandeService.findByClient(clientService.findById(id)));
                return mav;
            }

            // Detail demande + ses devis
            @GetMapping("/clients/{idClient}/demandes/{idDemande}")
            public ModelAndView demandeDetail(@PathVariable Long idClient, @PathVariable Long idDemande) {
                ModelAndView mav = new ModelAndView("dashboard/clients/devis");
                mav.addObject("client", clientService.findById(idClient));
                mav.addObject("demande", demandeService.findById(idDemande));
                mav.addObject("devis", devisService.findByDemande(demandeService.findById(idDemande)));
                return mav;
            }
            // Detail devis + ses lignes
            @GetMapping("/clients/{idClient}/demandes/{idDemande}/devis/{idDevis}")
            public ModelAndView devisDetail(@PathVariable Long idClient,
                                            @PathVariable Long idDemande,
                                            @PathVariable Long idDevis) {
                ModelAndView mav = new ModelAndView("dashboard/clients/detail-devis");
                mav.addObject("client", clientService.findById(idClient));
                mav.addObject("demande", demandeService.findById(idDemande));
                mav.addObject("devis", devisService.findById(idDevis));
                return mav;
            }
            // Liste tous les devis
            @GetMapping("/devis")
            public ModelAndView devis() {
                ModelAndView mav = new ModelAndView("dashboard/devis/list");
                mav.addObject("devis", devisService.findAll());
                return mav;
            }

            // Detail devis + client
            @GetMapping("/devis/{id}")
            public ModelAndView devisDetail(@PathVariable Long id) {
                Devis devis = devisService.findById(id);
                ModelAndView mav = new ModelAndView("dashboard/devis/detail");
                mav.addObject("devis", devis);
                mav.addObject("client", devis.getDemande().getClient());
                return mav;
            }
            @GetMapping("/chiffre-affaire")
            public ModelAndView chiffreAffaire() {
                ModelAndView mav = new ModelAndView("dashboard/ca");
                mav.addObject("details", detailDevisService.findAll());
                double total = detailDevisService.findAll().stream()
                        .mapToDouble(dd -> dd.getPu() * dd.getQte())
                        .sum();
                mav.addObject("total", total);
                return mav;
            }     
            // Detail demande depuis status
            @GetMapping("/status/{idStatus}/demandes/{idDemande}")
            public ModelAndView demandeDetailFromStatus(@PathVariable Long idStatus,
                                                        @PathVariable Long idDemande) {
                ModelAndView mav = new ModelAndView("dashboard/status/devis");
                mav.addObject("status", statusService.findById(idStatus));
                mav.addObject("demande", demandeService.findById(idDemande));
                mav.addObject("devis", devisService.findByDemande(demandeService.findById(idDemande)));
                return mav;
            }
}