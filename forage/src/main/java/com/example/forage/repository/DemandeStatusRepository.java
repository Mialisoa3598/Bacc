package com.example.forage.repository;

import com.example.forage.model.Demande;
import com.example.forage.model.DemandeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DemandeStatusRepository extends JpaRepository<DemandeStatus, Long> {
    List<DemandeStatus> findByDemandeOrderByDateDesc(Demande demande);
}