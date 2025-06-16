package org.example.deliverymatch.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Expediteur extends User{

    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL)
    private List<Demande> demandes;
}
