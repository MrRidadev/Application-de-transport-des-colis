package org.example.deliverymatch.service;

import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.repository.DemandeRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;
    @Autowired
    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    // ajouter demande
    public Demande addDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    // afficher demande

    public List<Demande> getDemandes() {
        return demandeRepository.findAll();
    }

}
