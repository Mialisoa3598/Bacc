package com.example.correction.controller;

import com.example.correction.model.Parametre;
import com.example.correction.service.*;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parametres")
public class ParametreController {
    private final ParametreService service;
    private final MatiereService matiereService;
    private final OperateurService operateurService;
    private final ResolutionService resolutionService;

    public ParametreController(ParametreService service,
                               MatiereService matiereService,
                               OperateurService operateurService,
                               ResolutionService resolutionService) {
        this.service = service;
        this.matiereService = matiereService;
        this.operateurService = operateurService;
        this.resolutionService = resolutionService;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("parametres", service.findAll());
    //     return "parametre/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("parametre/list");
        mav.addObject("parametres", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("parametre", new Parametre());
    //     model.addAttribute("matieres", matiereService.findAll());
    //     model.addAttribute("operateurs", operateurService.findAll());
    //     model.addAttribute("resolutions", resolutionService.findAll());
    //     return "parametre/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("parametre/form");
        mav.addObject("parametre", new Parametre());
        mav.addObject("matieres", matiereService.findAll());
        mav.addObject("operateurs", operateurService.findAll());
        mav.addObject("resolutions", resolutionService.findAll());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("parametre", service.findById(id));
    //     model.addAttribute("matieres", matiereService.findAll());
    //     model.addAttribute("operateurs", operateurService.findAll());
    //     model.addAttribute("resolutions", resolutionService.findAll());
    //     return "parametre/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("parametre/form");
        mav.addObject("parametre", service.findById(id));
        mav.addObject("matieres", matiereService.findAll());
        mav.addObject("operateurs", operateurService.findAll());
        mav.addObject("resolutions", resolutionService.findAll());
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Parametre parametre) {
    //     service.save(parametre);
    //     return "redirect:/parametres";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Parametre parametre) {
        service.save(parametre);
        return new ModelAndView("redirect:/parametres");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/parametres";
    // }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/parametres");
    }
}