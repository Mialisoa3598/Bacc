package com.example.forage.repository;

import com.example.forage.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByClient(Client client);
}