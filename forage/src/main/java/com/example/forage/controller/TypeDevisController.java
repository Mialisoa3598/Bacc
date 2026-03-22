package com.example.forage.controller;
import com.example.forage.model.TypeDevis;
import com.example.forage.service.TypeDevisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/typeDevis")
public class TypeDevisController {
    private final TypeDevisService typeDevisService;

    public TypeDevisController(TypeDevisService typeDevisService) {
        this.typeDevisService = typeDevisService;
    }

     @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("typeDevis/list");
        mav.addObject("typesDevis", typeDevisService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("typeDevis/form");
        mav.addObject("typeDevis", typeDevisService.findById(id));
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("typeDevis/form");
        mav.addObject("typeDevis", new TypeDevis());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute TypeDevis typeDevis) {
        typeDevisService.save(typeDevis);
        return new ModelAndView("redirect:/typeDevis");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        typeDevisService.delete(id);
        return new ModelAndView("redirect:/typeDevis");
    }
}
