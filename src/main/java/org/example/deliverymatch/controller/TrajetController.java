package org.example.deliverymatch.controller;

import org.example.deliverymatch.DTO.TrajetHistoriqueDTO;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.service.TrajetService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Trajet")
public class TrajetController {

    private final TrajetService trajetService;
    public TrajetController(TrajetService conducteurService) {
        this.trajetService = conducteurService;
    }

    @PostMapping(value="/ajouterTrajet", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Trajet addTrajet(@RequestBody Trajet trajet) {
        return trajetService.addTrajet(trajet);
    }

    @GetMapping("/findAllTrajet")
    public List<TrajetHistoriqueDTO> findAll() {
        return trajetService.findAll();
    }





    @GetMapping("/filtrer")
    public List<Trajet> filtrerTrajets(
            @RequestParam String lieuDepart,
            @RequestParam String destinationFinale) {

        return trajetService.filtrerParLieuEtDestination(lieuDepart, destinationFinale);
    }
}
