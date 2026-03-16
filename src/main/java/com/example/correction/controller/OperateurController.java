package com.example.correction.controller;

import com.example.correction.model.Operateur;
import com.example.correction.service.OperateurService;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/operateurs")
public class OperateurController {
    private final OperateurService service;

    public OperateurController(OperateurService service) {
        this.service = service;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("operateurs", service.findAll());
    //     return "operateur/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("operateur/list");
        mav.addObject("operateurs", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("operateur", new Operateur());
    //     return "operateur/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() { 
        ModelAndView mav = new ModelAndView("operateur/form");
        mav.addObject("operateur", new Operateur());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("operateur", service.findById(id));
    //     return "operateur/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("operateur/form");
        mav.addObject("operateur", service.findById(id));
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Operateur operateur) {
    //     service.save(operateur);
    //     return "redirect:/operateurs";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Operateur operateur) {
        service.save(operateur);
        return new ModelAndView("redirect:/operateurs");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/operateurs";
    // }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/operateurs");
    }
}