package com.example.forage.controller;
import com.example.forage.model.Demande;
import com.example.forage.service.ClientService;
import com.example.forage.service.DemandeService;  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demandes")
public class DemandeController {
    private final DemandeService demandeService;
    private final ClientService clientService;

    public DemandeController(DemandeService demandeService, ClientService clientService) {
        this.demandeService = demandeService;
        this.clientService = clientService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("demandes/list");
        mav.addObject("demandes", demandeService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("demandes/form");
        mav.addObject("demande", demandeService.findById(id));
        mav.addObject("clients", clientService.findAll());
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("demandes/form");
        mav.addObject("demande", new Demande());
        mav.addObject("clients", clientService.findAll());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Demande demande) {
        demandeService.save(demande);
        return new ModelAndView("redirect:/demandes");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        demandeService.delete(id);
        return new ModelAndView("redirect:/demandes");
    }
}
