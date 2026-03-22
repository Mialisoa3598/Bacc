package com.example.forage.controller;

import com.example.forage.model.Client;
import com.example.forage.service.ClientService;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("client/list");
        mav.addObject("clients", clientService.findAll());
        return mav;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("client/form");
        mav.addObject("client", clientService.findById(id));
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newForm() {
        ModelAndView mav = new ModelAndView("client/form");
        mav.addObject("client", new Client());
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Client client) {
        clientService.save(client);
        return new ModelAndView("redirect:/clients");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        clientService.delete(id);
        return new ModelAndView("redirect:/clients");
    }

}