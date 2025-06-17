package org.example.deliverymatch.service;


import org.example.deliverymatch.entity.Administrateur;
import org.example.deliverymatch.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    private final AdministrateurRepository userRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Administrateur createAdministrateur(Administrateur administrateur) {
        return userRepository.save(administrateur);

    }

    public List<Administrateur> findAll() {
        return userRepository.findAll();
    }
}
