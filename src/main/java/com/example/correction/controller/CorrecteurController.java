package com.example.correction.controller;

import com.example.correction.model.Correcteur;
import com.example.correction.service.CorrecteurService;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/correcteurs")
public class CorrecteurController {
    private final CorrecteurService service;

    public CorrecteurController(CorrecteurService service) {
        this.service = service;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("correcteurs", service.findAll());
    //     return "correcteur/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("correcteur/list");
        mav.addObject("correcteurs", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("correcteur", new Correcteur());
    //     return "correcteur/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("correcteur/form");
        mav.addObject("correcteur", new Correcteur());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("correcteur", service.findById(id));
    //     return "correcteur/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("correcteur/form");
        mav.addObject("correcteur", service.findById(id));
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Correcteur correcteur) {
    //     service.save(correcteur);
    //     return "redirect:/correcteurs";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Correcteur correcteur) {
        service.save(correcteur);
        return new ModelAndView("redirect:/correcteurs");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/correcteurs";
    // }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/correcteurs");
    }
}