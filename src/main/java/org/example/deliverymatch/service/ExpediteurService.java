package org.example.deliverymatch.service;

import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.repository.ConducteurRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpediteurService {

    private final ExpediteurRepository expediteurRepository;

    @Autowired
    public ExpediteurService(ExpediteurRepository expediteurRepository) {
        this.expediteurRepository = expediteurRepository;
    }
// ajouter expediteur
    public Expediteur addExpediteur(Expediteur expediteur) {
        return expediteurRepository.save(expediteur);
    }

    //afficher tout expediteur
    public List<Expediteur> getExpediteurs() {
        return expediteurRepository.findAll();
    }
}
