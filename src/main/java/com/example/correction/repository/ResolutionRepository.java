package com.example.correction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.correction.model.Resolution;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
    Optional<Resolution> findByNomIgnoreCase(String nom);
}