package com.example.forage.controller;
import com.example.forage.service.DemandeService;
import com.example.forage.service.DemandeStatusService;
import com.example.forage.service.StatusService;
import org.springframework.stereotype.Controller;
import com.example.forage.model.DemandeStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demande-status")
public class DemandeStatusController {
    private final DemandeStatusService demandeStatusService;
    private final DemandeService demandeService;
    private final StatusService statusService;

    public DemandeStatusController(DemandeStatusService demandeStatusService,
                                    DemandeService demandeService,
                                    StatusService statusService) {
        this.demandeStatusService = demandeStatusService;
        this.demandeService = demandeService;
        this.statusService = statusService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("demande-status/list");
        mav.addObject("demandeStatuts", demandeStatusService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("demande-status/form");
        mav.addObject("demandeStatus", demandeStatusService.findById(id));
        mav.addObject("demandes", demandeService.findAll());
        mav.addObject("statuts", statusService.findAll());
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("demande-status/form");
        mav.addObject("demandeStatus", new DemandeStatus());
        mav.addObject("demandes", demandeService.findAll());
        mav.addObject("statuts", statusService.findAll());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute DemandeStatus demandeStatus) {
        demandeStatusService.save(demandeStatus);
        return new ModelAndView("redirect:/demande-status");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        demandeStatusService.delete(id);
        return new ModelAndView("redirect:/demande-status");
    }
}
