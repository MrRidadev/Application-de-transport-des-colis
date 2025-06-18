package org.example.deliverymatch.repository;


import org.example.deliverymatch.entity.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {


    // afficher historique de trajet et les colies par conducteur
    List<Trajet> findByConducteurId(Long conducteurId);
}
