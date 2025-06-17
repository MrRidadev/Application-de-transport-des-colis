package org.example.deliverymatch.controller;

import org.example.deliverymatch.service.ConducteurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Conducteur")
public class ConducteurController {

    private final ConducteurService conducteurService;
    public ConducteurController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }
}
