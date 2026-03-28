package com.example.forage.repository;

import com.example.forage.model.Status;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByLibelleIgnoreCase(String libelle);
}