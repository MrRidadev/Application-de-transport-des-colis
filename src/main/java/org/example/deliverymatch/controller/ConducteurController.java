package org.example.deliverymatch.controller;


import org.example.deliverymatch.DTO.TrajetHistoriqueDTO;
import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.service.ConducteurService;
import org.example.deliverymatch.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Conducteur")
public class ConducteurController {

    @Autowired
    private TrajetService trajetService;

    private final ConducteurService userService;
    @Autowired
    public ConducteurController(ConducteurService userService) {
        this.userService = userService;
    }


    @PostMapping("/createConducteur")
    public Conducteur createConducteur(@RequestBody Conducteur conducteur) {
        return userService.createConducteur(conducteur);
    }

    @GetMapping("/findAllConducteur")
    public List<Conducteur> findAllConducteur() {
        return userService.getAllConducteur();
    }

    @GetMapping("/{id}/historique")
    public List<TrajetHistoriqueDTO> getHistorique(@PathVariable Long id) {
        return trajetService.getHistoriqueConducteur(id);
    }
}
