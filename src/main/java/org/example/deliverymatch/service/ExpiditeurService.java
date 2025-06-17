package org.example.deliverymatch.service;

import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpiditeurService {

    private final ExpediteurRepository expediteurRepository;
    @Autowired
    public ExpiditeurService(ExpediteurRepository expediteurRepository) {
        this.expediteurRepository = expediteurRepository;
    }

}
