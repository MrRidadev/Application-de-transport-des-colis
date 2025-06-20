package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {

    Optional<Conducteur> findByEmail(String email);
}
