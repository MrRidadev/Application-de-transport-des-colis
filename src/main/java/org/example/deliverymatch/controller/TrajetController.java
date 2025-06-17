package org.example.deliverymatch.controller;

import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.service.TrajetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Trajet")
public class TrajetController {

    private final TrajetService trajetService;
    public TrajetController(TrajetService conducteurService) {
        this.trajetService = conducteurService;
    }

    @PostMapping("/ajouterTrajet")
    public Trajet addTrajet(@RequestBody Trajet trajet) {
        return trajetService.addTrajet(trajet);
    }

    @GetMapping("/findAllTrajet")
    public List<Trajet> findAll() {
        return trajetService.findAll();
    }
}
