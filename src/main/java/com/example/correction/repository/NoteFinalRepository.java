package com.example.correction.repository;

import com.example.correction.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteFinalRepository extends JpaRepository<NoteFinal, Long> {
    Optional<NoteFinal> findByMatiereAndCandidat(Matiere matiere, Candidat candidat);
}