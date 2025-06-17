package org.example.deliverymatch.service;

import org.example.deliverymatch.entity.Conducteur;
import org.example.deliverymatch.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurService {

    private final ConducteurRepository conducteurrepository;
    @Autowired
    public ConducteurService(ConducteurRepository conducteurrepository) {
        this.conducteurrepository = conducteurrepository;
    }


    public Conducteur createConducteur(Conducteur conducteur) {
        return conducteurrepository.save(conducteur);
    }

    public List<Conducteur> getAllConducteur() {
        return conducteurrepository.findAll();
    }
}
