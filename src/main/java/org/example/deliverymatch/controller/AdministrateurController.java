package org.example.deliverymatch.controller;


import org.example.deliverymatch.entity.Administrateur;
import org.example.deliverymatch.entity.User;
import org.example.deliverymatch.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Administrateur")

public class AdministrateurController {

    private final AdministrateurService userService;
    @Autowired
    public AdministrateurController(AdministrateurService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllAdministrateur")
    public List<Administrateur> getAdministrateur() {
        return userService.findAll();
    }
    @PostMapping("/ajouterAdministrateur")
    public Administrateur ajouterAdministrateur(@RequestBody Administrateur administrateur) {
        return userService.createAdministrateur(administrateur);
    }
}
