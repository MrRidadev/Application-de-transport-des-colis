package org.example.deliverymatch.service;

import org.example.deliverymatch.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpediteurService {

    private final ConducteurRepository conducteurRepository;

    @Autowired
    public ExpediteurService(ConducteurRepository conducteurRepository) {
        this.conducteurRepository = conducteurRepository;
    }
}
