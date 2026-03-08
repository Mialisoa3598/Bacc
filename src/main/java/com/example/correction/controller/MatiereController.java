package com.example.correction.controller;

import com.example.correction.model.Matiere;
import com.example.correction.service.MatiereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matieres")
public class MatiereController {
    private final MatiereService service;

    public MatiereController(MatiereService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("matieres", service.findAll());
        return "matiere/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("matiere", new Matiere());
        return "matiere/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("matiere", service.findById(id));
        return "matiere/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Matiere matiere) {
        service.save(matiere);
        return "redirect:/matieres";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/matieres";
    }
}