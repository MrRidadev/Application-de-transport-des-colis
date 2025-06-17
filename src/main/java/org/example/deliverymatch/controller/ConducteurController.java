package org.example.deliverymatch.controller;


import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Conducteur")
public class ConducteurController {

    private final ConducteurService userService;
    @Autowired
    public ConducteurController(ConducteurService userService) {
        this.userService = userService;
    }


    @PostMapping("createConducteur")
    public Conducteur createConducteur(Conducteur conducteur) {
        return userService.createConducteur(conducteur);
    }
}
