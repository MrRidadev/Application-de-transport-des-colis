package org.example.deliverymatch.repository;

import org.example.deliverymatch.entity.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
}
