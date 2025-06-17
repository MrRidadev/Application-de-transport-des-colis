package org.example.deliverymatch.controller;



import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.service.ConducteurService;
import org.example.deliverymatch.service.ExpediteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Expediteur")
public class ExpediteurControler {

    private final ExpediteurService expediteurService;

    @Autowired
    public ExpediteurControler(ExpediteurService expediteurService) {
        this.expediteurService = expediteurService;
    }


    // ajouter expediteur
    @PostMapping("/addExpediteur")
    public Expediteur addExpediteur(@RequestBody Expediteur expediteur) {
        return expediteurService.addExpediteur(expediteur);
    }

    // afficher touts expediteur
    @GetMapping("/getAllExpediteur")
    public List<Expediteur> getExpediteurs() {
        return expediteurService.getExpediteurs();
    }


}
