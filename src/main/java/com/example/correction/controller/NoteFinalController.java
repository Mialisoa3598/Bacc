package com.example.correction.controller;

import com.example.correction.model.*;
import com.example.correction.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note-final")
public class NoteFinalController {
    private final NoteFinalService service;
    private final MatiereService matiereService;
    private final CandidatService candidatService;

    public NoteFinalController(NoteFinalService service,
                               MatiereService matiereService,
                               CandidatService candidatService) {
        this.service = service;
        this.matiereService = matiereService;
        this.candidatService = candidatService;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("matieres", matiereService.findAll());
        model.addAttribute("candidats", candidatService.findAll());
        return "note-final/show";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("matieres", matiereService.findAll());
        model.addAttribute("candidats", candidatService.findAll());
        model.addAttribute("notesFinals", service.findAll());
        return "note-final/list";
    }

    @PostMapping("/calculer")
    public String calculer(@RequestParam Long idMatiere,
                           @RequestParam Long idCandidat,
                           Model model) {
        Matiere matiere = matiereService.findById(idMatiere);
        Candidat candidat = candidatService.findById(idCandidat);
        NoteFinal noteFinal = service.saveOrUpdate(matiere, candidat);

        model.addAttribute("matieres", matiereService.findAll());
        model.addAttribute("candidats", candidatService.findAll());
        model.addAttribute("noteFinal", noteFinal);
        model.addAttribute("selectedMatiere", idMatiere);
        model.addAttribute("selectedCandidat", idCandidat);
        return "note-final/show";
    }
}