package com.example.correction.controller;

import com.example.correction.model.Operateur;
import com.example.correction.service.OperateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operateurs")
public class OperateurController {
    private final OperateurService service;

    public OperateurController(OperateurService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("operateurs", service.findAll());
        return "operateur/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("operateur", new Operateur());
        return "operateur/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("operateur", service.findById(id));
        return "operateur/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Operateur operateur) {
        service.save(operateur);
        return "redirect:/operateurs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/operateurs";
    }
}