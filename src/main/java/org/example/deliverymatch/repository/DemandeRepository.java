package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

    // afficher les demandes par expediteur
    List<Demande> findByExpediteurId(Long expediteurId);
}
