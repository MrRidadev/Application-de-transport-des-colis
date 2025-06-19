package org.example.deliverymatch.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Expediteur extends User{

    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Demande> demandes;
}
