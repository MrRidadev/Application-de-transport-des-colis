package org.example.deliverymatch.controller;

import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.service.TrajetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Trajet")
public class TrajetController {

    private final TrajetService trajetService;
    public TrajetController(TrajetService conducteurService) {
        this.trajetService = conducteurService;
    }

    public Trajet addTrajet(Trajet trajet) {
        return trajetService.addTrajet(trajet);
    }
}
