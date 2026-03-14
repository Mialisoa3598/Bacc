package com.example.correction.controller;

import com.example.correction.model.Note;
import com.example.correction.service.*;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private final NoteService service;
    private final MatiereService matiereService;
    private final CandidatService candidatService;
    private final CorrecteurService correcteurService;

    public NoteController(NoteService service,
                          MatiereService matiereService,
                          CandidatService candidatService,
                          CorrecteurService correcteurService) {
        this.service = service;
        this.matiereService = matiereService;
        this.candidatService = candidatService;
        this.correcteurService = correcteurService;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("notes", service.findAll());
    //     return "note/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("note/list");
        mav.addObject("notes", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("note", new Note());
    //     model.addAttribute("matieres", matiereService.findAll());
    //     model.addAttribute("candidats", candidatService.findAll());
    //     model.addAttribute("correcteurs", correcteurService.findAll());
    //     return "note/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("note/form");
        mav.addObject("note", new Note());
        mav.addObject("matieres", matiereService.findAll());
        mav.addObject("candidats", candidatService.findAll());
        mav.addObject("correcteurs", correcteurService.findAll());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("note", service.findById(id));
    //     model.addAttribute("matieres", matiereService.findAll());
    //     model.addAttribute("candidats", candidatService.findAll());
    //     model.addAttribute("correcteurs", correcteurService.findAll());
    //     return "note/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {   
        ModelAndView mav = new ModelAndView("note/form");
        mav.addObject("note", service.findById(id));
        mav.addObject("matieres", matiereService.findAll());
        mav.addObject("candidats", candidatService.findAll());
        mav.addObject("correcteurs", correcteurService.findAll());
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Note note) {
    //     service.save(note);
    //     return "redirect:/notes";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Note note) {
        service.save(note);
        return new ModelAndView("redirect:/notes");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/notes";
    // }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/notes");
    }
}