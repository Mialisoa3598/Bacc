package com.example.correction.controller;

import com.example.correction.model.Correcteur;
import com.example.correction.service.CorrecteurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/correcteurs")
public class CorrecteurController {
    private final CorrecteurService service;

    public CorrecteurController(CorrecteurService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("correcteurs", service.findAll());
        return "correcteur/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("correcteur", new Correcteur());
        return "correcteur/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("correcteur", service.findById(id));
        return "correcteur/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Correcteur correcteur) {
        service.save(correcteur);
        return "redirect:/correcteurs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/correcteurs";
    }
}