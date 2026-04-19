package com.example.forage.repository;

import com.example.forage.model.Demande;
import com.example.forage.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DevisRepository extends JpaRepository<Devis, Long> {
    List<Devis> findByDemande(Demande demande);
    @Query("SELECT SUM(dd.pu * dd.qte) FROM DetailDevis dd WHERE dd.devis.id = :idDevis")
    Double sommeMontantDevis(@Param("idDevis") Long idDevis);
}