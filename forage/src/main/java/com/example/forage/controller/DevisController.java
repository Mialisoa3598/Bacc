package com.example.forage.controller;
import com.example.forage.service.DemandeService;
import com.example.forage.service.DetailDevisService;
import com.example.forage.service.DevisService;
import com.example.forage.service.TypeDevisService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.forage.model.DetailDevis;
import com.example.forage.model.Devis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/devis")
public class DevisController {
    private final DetailDevisService detailDevisService;
    private final DevisService devisService;
    private final TypeDevisService typeDevisService;
    private final DemandeService demandeService;

    public DevisController(DevisService devisService, TypeDevisService typeDevisService, DemandeService demandeService, DetailDevisService detailDevisService) {
        this.devisService = devisService;
        this.typeDevisService = typeDevisService;
        this.demandeService = demandeService;
        this.detailDevisService = detailDevisService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("devis/list");
        mav.addObject("devis", devisService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("devis/form");
        mav.addObject("devis", devisService.findById(id));
        mav.addObject("typeDevis", typeDevisService.findAll());
        mav.addObject("demandes", demandeService.findAll());
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("devis/form");
        mav.addObject("devis", new Devis());
        mav.addObject("typeDevis", typeDevisService.findAll());
        mav.addObject("demandes", demandeService.findAll());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(
            @RequestParam Integer id,
            @RequestParam Integer idTypeDevis,
            @RequestParam Integer idDemande,
            @RequestParam List<String> libelles,
            @RequestParam List<Double> pus,
            @RequestParam List<Integer> qtes) {

        Devis devis = new Devis();
        if (id != 0) {
            devis = devisService.findById(id.longValue());
            devis.setTypeDevis(typeDevisService.findById(idTypeDevis.longValue()));
            devis.setDemande(demandeService.findById(idDemande.longValue()));
            devisService.update(devis);
        } else {
            devis.setTypeDevis(typeDevisService.findById(idTypeDevis.longValue()));
            devis.setDemande(demandeService.findById(idDemande.longValue()));
            devis.setDate(LocalDate.now());
            List<DetailDevis> details = new ArrayList<>();
            for (int i = 0; i < libelles.size(); i++) {
                DetailDevis detail = new DetailDevis();
                detail.setLibelle(libelles.get(i));
                detail.setPu(pus.get(i));
                detail.setQte(qtes.get(i));
                details.add(detail);
            }

            // Passer le devis ET ses details a createDevis()
            devisService.createDevis(devis, details);
        }
        return new ModelAndView("redirect:/devis");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        devisService.delete(id);
        return new ModelAndView("redirect:/devis");
    }
}
