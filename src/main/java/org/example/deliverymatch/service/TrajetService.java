package org.example.deliverymatch.service;

import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajetService {

    private TrajetRepository trajetRepository;

    @Autowired
    public TrajetService(TrajetRepository conducteurRepository) {
        this.trajetRepository = conducteurRepository;
    }


    public Trajet addTrajet(Trajet trajet) {
       return trajetRepository.save(trajet);
    }
}
