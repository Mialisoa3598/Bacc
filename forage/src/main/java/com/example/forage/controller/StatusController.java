package com.example.forage.controller;
import com.example.forage.model.Status;
import com.example.forage.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("status/list");
        mav.addObject("statuts", statusService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("status/form");
        mav.addObject("status", statusService.findById(id));
        return mav;
    }   

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("status/form");
        mav.addObject("status", new Status());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Status status) {
        statusService.save(status);
        return new ModelAndView("redirect:/status");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        statusService.delete(id);
        return new ModelAndView("redirect:/status");
    }
}
