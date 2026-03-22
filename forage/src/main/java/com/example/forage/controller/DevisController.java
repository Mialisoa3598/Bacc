package com.example.forage.controller;
import com.example.forage.service.DemandeService;
import com.example.forage.service.DevisService;
import com.example.forage.service.TypeDevisService;

import org.springframework.stereotype.Controller;
import com.example.forage.model.Devis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/devis")
public class DevisController {
    private final DevisService devisService;
    private final TypeDevisService typeDevisService;
    private final DemandeService demandeService;

    public DevisController(DevisService devisService, TypeDevisService typeDevisService, DemandeService demandeService) {
        this.devisService = devisService;
        this.typeDevisService = typeDevisService;
        this.demandeService = demandeService;
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
    public ModelAndView save(@ModelAttribute Devis devis) {
        devisService.save(devis);
        return new ModelAndView("redirect:/devis");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        devisService.delete(id);
        return new ModelAndView("redirect:/devis");
    }
}
