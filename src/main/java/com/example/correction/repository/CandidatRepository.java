package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.correction.model.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
