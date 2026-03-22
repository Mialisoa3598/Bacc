package com.example.forage.repository;

import com.example.forage.model.DetailDevis;
import com.example.forage.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetailDevisRepository extends JpaRepository<DetailDevis, Long> {
    List<DetailDevis> findByDevis(Devis devis);
}