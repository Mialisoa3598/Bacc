package com.example.correction.controller;

import com.example.correction.model.Resolution;
import com.example.correction.service.ResolutionService;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resolutions")
public class ResolutionController {
    private final ResolutionService service;

    public ResolutionController(ResolutionService service) {
        this.service = service;
    }

    // @GetMapping
    // public String list(Model model) {
    //     model.addAttribute("resolutions", service.findAll());
    //     return "resolution/list";
    // }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("resolution/list");
        mav.addObject("resolutions", service.findAll());
        return mav;
    }

    // @GetMapping("/new")
    // public String newForm(Model model) {
    //     model.addAttribute("resolution", new Resolution());
    //     return "resolution/form";
    // }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("resolution/form");
        mav.addObject("resolution", new Resolution());
        return mav;
    }

    // @GetMapping("/edit/{id}")
    // public String editForm(@PathVariable Long id, Model model) {
    //     model.addAttribute("resolution", service.findById(id));
    //     return "resolution/form";
    // }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("resolution/form");
        mav.addObject("resolution", service.findById(id));
        return mav;
    }

    // @PostMapping("/save")
    // public String save(@ModelAttribute Resolution resolution) {
    //     service.save(resolution);
    //     return "redirect:/resolutions";
    // }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Resolution resolution) {
        service.save(resolution);
        return new ModelAndView("redirect:/resolutions");
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     service.delete(id);
    //     return "redirect:/resolutions";
    // }

        @GetMapping("/delete/{id}")
        public ModelAndView delete(@PathVariable Long id) {
            service.delete(id);
            return new ModelAndView("redirect:/resolutions");
        }
}