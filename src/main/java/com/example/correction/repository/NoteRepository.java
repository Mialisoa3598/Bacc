package com.example.correction.repository;

import com.example.correction.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByMatiereAndCandidat(Matiere matiere, Candidat candidat);
}