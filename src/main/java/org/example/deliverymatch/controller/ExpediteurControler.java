package org.example.deliverymatch.controller;



import org.example.deliverymatch.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Expediteur")
public class ExpediteurControler {

    private final ConducteurService conducteurService;

    @Autowired
    public ExpediteurControler(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }


}
