package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Expediteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpediteurRepository extends JpaRepository<Expediteur, Long> {

    Optional<Expediteur> findByEmail(String email);
}
