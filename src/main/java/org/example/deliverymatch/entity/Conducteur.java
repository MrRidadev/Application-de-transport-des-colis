package org.example.deliverymatch.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Conducteur extends User {

    public Conducteur() {
        super.setRole(Role.valueOf("Conducteur"));
    }

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Trajet> trajets;
}
