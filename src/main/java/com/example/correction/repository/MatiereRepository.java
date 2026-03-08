package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.correction.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
}
