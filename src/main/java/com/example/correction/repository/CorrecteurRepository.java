package com.example.correction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.correction.model.Correcteur;
public interface CorrecteurRepository extends JpaRepository<Correcteur, Long> {
}
