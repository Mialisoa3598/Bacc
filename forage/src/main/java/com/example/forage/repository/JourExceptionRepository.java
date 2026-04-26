package com.example.forage.repository;

import com.example.forage.model.JourException;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface JourExceptionRepository extends JpaRepository<JourException, Long> {
    boolean existsByDateException(LocalDate dateException);
}