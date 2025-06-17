package org.example.deliverymatch.controller;



import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.service.ConducteurService;
import org.example.deliverymatch.service.ExpediteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Expediteur")
public class ExpediteurControler {

    private final ExpediteurService expediteurService;

    @Autowired
    public ExpediteurControler(ExpediteurService expediteurService) {
        this.expediteurService = expediteurService;
    }

    @PostMapping("/addExpediteur")
    public Expediteur addExpediteur(@RequestBody Expediteur expediteur) {
        return expediteurService.addExpediteur(expediteur);
    }


}
