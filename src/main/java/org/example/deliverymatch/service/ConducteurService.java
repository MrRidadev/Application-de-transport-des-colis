package org.example.deliverymatch.service;

import org.example.deliverymatch.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConducteurService {

    private ConducteurRepository conducteurRepository;

    @Autowired
    public ConducteurService(ConducteurRepository conducteurRepository) {
        this.conducteurRepository = conducteurRepository;
    }

}
