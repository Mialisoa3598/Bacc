// package com.example.forage.controller;
// import com.example.forage.service.DemandeService;
// import com.example.forage.service.DemandeStatusService;
// import com.example.forage.service.StatusService;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.stereotype.Controller;

// import com.example.forage.model.Demande;
// import com.example.forage.model.DemandeStatus;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// @RequestMapping("/demande-status")
// public class DemandeStatusController {
//     private final DemandeStatusService demandeStatusService;
//     private final DemandeService demandeService;
//     private final StatusService statusService;

//     public DemandeStatusController(DemandeStatusService demandeStatusService,
//                                     DemandeService demandeService,
//                                     StatusService statusService) {
//         this.demandeStatusService = demandeStatusService;
//         this.demandeService = demandeService;
//         this.statusService = statusService;
//     }

//     // @GetMapping
//     // public ModelAndView list() {
//     //     ModelAndView mav = new ModelAndView("demande-status/list");
//     //     mav.addObject("demandeStatuts", demandeStatusService.findAll());
//     //     return mav;
//     // }

//     @GetMapping
//     public ModelAndView page() {
//         ModelAndView mav = new ModelAndView("demande-status/page");

//         mav.addObject("demandes", demandeService.findAll());
//         mav.addObject("statuts", statusService.findAll());

//         return mav;
//     }

//     @GetMapping("/edit/{id}")
//     public ModelAndView editForm(@PathVariable Long id) {
//         ModelAndView mav = new ModelAndView("demande-status/form");
//         mav.addObject("demandeStatus", demandeStatusService.findById(id));
//         mav.addObject("demandes", demandeService.findAll());
//         mav.addObject("statuts", statusService.findAll());
//         return mav;
//     }

//     @GetMapping("/new")
//     public ModelAndView newForm() {
//         ModelAndView mav = new ModelAndView("demande-status/form");
//         mav.addObject("demandeStatus", new DemandeStatus());
//         mav.addObject("demandes", demandeService.findAll());
//         mav.addObject("statuts", statusService.findAll());
//         return mav;
//     }

//     @PostMapping("/save")
//     public ModelAndView save(@ModelAttribute DemandeStatus demandeStatus) {
//         demandeStatusService.save(demandeStatus);
//         return new ModelAndView("redirect:/demande-status");
//     }

//     @GetMapping("/delete/{id}")
//     public ModelAndView delete(@PathVariable Long id) {
//         demandeStatusService.delete(id);
//         return new ModelAndView("redirect:/demande-status");
//     }

//         @GetMapping("/api/demande-status/{idDemande}")
//         @ResponseBody
//         public List<DemandeStatus> getHistoriqueAjax(@PathVariable Long idDemande) {

//             Demande demande = demandeService.findById(idDemande);

//             if (demande == null) {
//                 return new ArrayList<>();
//             }

//             return demandeStatusService.getHistorique(demande);
//         }

//                 // @GetMapping("/api/test-status")
//                 // @ResponseBody
//                 // public List<DemandeStatus> testAll() {
//                 //     return demandeStatusService.findAll();
//                 // }
// }
package com.example.forage.controller;

import com.example.forage.model.Demande;
import com.example.forage.model.DemandeStatus;
import com.example.forage.service.DemandeService;
import com.example.forage.service.DemandeStatusService;
import com.example.forage.service.StatusService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// import java.time.LocalDate;
import java.time.LocalDateTime;
// import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
import java.util.List;

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
    public ModelAndView page() {

        ModelAndView mav = new ModelAndView("demande-status/page");

        mav.addObject("demandes", demandeService.findAll());
        mav.addObject("statuts", statusService.findAll());

        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute DemandeStatus ds) {

        ds.setDate(LocalDateTime.now());
        demandeStatusService.save(ds);

        return new ModelAndView("redirect:/demande-status");
    }


    @GetMapping("/api/demande-status/{idDemande}")
    @ResponseBody
    public List<DemandeStatus> historique(@PathVariable Long idDemande) {

        Demande demande = demandeService.findById(idDemande);

        if (demande == null) {
            return List.of();
        }

        return demandeStatusService.getHistorique(demande);
    }


    @PostMapping("/update")
    @ResponseBody
    public String updateObservation(@RequestParam Long id,
                                    @RequestParam String observation) {

        DemandeStatus ds = demandeStatusService.findById(id);

        if (ds == null) {
            return "error";
        }

        ds.setObservation(observation);
        demandeStatusService.save(ds);

        return "ok";
    }

            // Afficher la page gestion
        @GetMapping("/gestion")
        public ModelAndView gestion() {
            ModelAndView mav = new ModelAndView("demande-status/gestion");
            mav.addObject("demandes", demandeService.findAll());
            mav.addObject("statuts", statusService.findAll());
            return mav;
        }

        // Creer un nouveau DemandeStatus
        @PostMapping("/gestion/save")
        public ModelAndView gestionSave(
                @RequestParam Integer idDemande,
                @RequestParam Integer idStatus,
                @RequestParam(required = false) String observation,
                @RequestParam String date) {
            DemandeStatus ds = new DemandeStatus();
            ds.setDemande(demandeService.findById(idDemande.longValue()));
            ds.setStatus(statusService.findById(idStatus.longValue()));
            ds.setObservation(observation);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            ds.setDate(LocalDateTime.parse(date, formatter));
            demandeStatusService.save(ds);
            return new ModelAndView("redirect:/demande-status/gestion");
        }

        // Modifier observation et date d'un DemandeStatus existant
        @PostMapping("/gestion/update")
        public ModelAndView gestionUpdate(
                @RequestParam Integer id,
                @RequestParam(required = false) String observation,
                @RequestParam String date) {
            demandeStatusService.update(id, observation, date);
            return new ModelAndView("redirect:/demande-status/gestion");
        }
}