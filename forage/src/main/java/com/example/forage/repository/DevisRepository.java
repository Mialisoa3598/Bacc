package com.example.forage.repository;

import com.example.forage.model.Demande;
import com.example.forage.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DevisRepository extends JpaRepository<Devis, Long> {
    List<Devis> findByDemande(Demande demande);
}