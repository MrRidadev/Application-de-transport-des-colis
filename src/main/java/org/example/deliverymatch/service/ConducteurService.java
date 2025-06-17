package org.example.deliverymatch.service;

import org.example.deliverymatch.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConducteurService {

    private final ConducteurRepository conducteurrepository;
    @Autowired
    public ConducteurService(ConducteurRepository conducteurrepository) {
        this.conducteurrepository = conducteurrepository;
    }


}
