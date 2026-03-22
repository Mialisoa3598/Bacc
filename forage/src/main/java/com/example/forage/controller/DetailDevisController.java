package com.example.forage.controller;
import com.example.forage.model.DetailDevis;
// import com.example.forage.model.Devis;
import com.example.forage.service.DetailDevisService;
import com.example.forage.service.DevisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/detail-devis")
public class DetailDevisController {
    private final DetailDevisService detailDevisService;
    private final DevisService devisService;

    public DetailDevisController(DetailDevisService detailDevisService,
                                  DevisService devisService) {
        this.detailDevisService = detailDevisService;
        this.devisService = devisService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("detail-devis/list");
        mav.addObject("detailDevis", detailDevisService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("detail-devis/form");
        mav.addObject("detailDevis", detailDevisService.findById(id));
        mav.addObject("devis", devisService.findAll());
        return mav;
    }   

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("detail-devis/form");
        mav.addObject("detailDevis", new DetailDevis());
        mav.addObject("devis", devisService.findAll());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute DetailDevis detailDevis) {
        detailDevisService.save(detailDevis);
        return new ModelAndView("redirect:/detail-devis");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        detailDevisService.delete(id);
        return new ModelAndView("redirect:/detail-devis");
    }


}
