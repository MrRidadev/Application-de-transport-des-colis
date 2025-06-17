package org.example.deliverymatch.controller;


import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.example.deliverymatch.service.DemandeService;
import org.example.deliverymatch.service.ExpediteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Demande")
public class DemandeController {

    private final DemandeService demandeService;

    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    // ajouter demande
    @PostMapping("/addDemande")
    public Demande addDemande(@RequestBody Demande demande) {
        return demandeService.addDemande(demande);
    }

    //afficher Demande
    @GetMapping("/getdemande")
    public List<Demande> getDemandes() {
        return demandeService.getDemandes();
    }
}
