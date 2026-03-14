package com.example.correction.controller;

import com.example.correction.model.Candidat;
// import com.example.correction.model.Correcteur;
import com.example.correction.service.CandidatService;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/candidats")
public class CandidatController {
    private final CandidatService service;

    public CandidatController(CandidatService service) {
        this.service = service;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("candidats", service.findAll());
    //     return "candidat/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("candidat/list");
        mav.addObject("candidats", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("candidat", new Candidat());
    //     return "candidat/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("candidat/form");
        mav.addObject("candidat", new Candidat());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("candidat", service.findById(id));
    //     return "candidat/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("candidat/form");
        mav.addObject("candidat", service.findById(id));
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Candidat candidat) {
    //     service.save(candidat);
    //     return "redirect:/candidats";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Candidat candidat) {
        service.save(candidat);
        return new ModelAndView("redirect:/candidats");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/candidats";
    // }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/candidats");
    }
}