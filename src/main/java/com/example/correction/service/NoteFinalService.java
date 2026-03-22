package com.example.correction.service;

import com.example.correction.model.*;
import com.example.correction.repository.NoteFinalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteFinalService {
    private final NoteFinalRepository repository;
    private final NoteService noteService;
    private final ParametreService parametreService;

    public NoteFinalService(NoteFinalRepository repository,
                            NoteService noteService,
                            ParametreService parametreService) {
        this.repository = repository;
        this.noteService = noteService;
        this.parametreService = parametreService;
    }

    public List<NoteFinal> findAll() { 
        return repository.findAll(); 
    }

    public NoteFinal getNoteFinal(Matiere matiere, Candidat candidat) {
        return repository.findByMatiereAndCandidat(matiere, candidat).orElse(null);
    }

    public NoteFinal saveOrUpdate(Matiere matiere, Candidat candidat) {
        double diff = noteService.calculSommeDifference(matiere, candidat);
        Parametre parametre = parametreService.getParametre(matiere, diff);
        List<Note> notes = noteService.getNotes(matiere, candidat);

        String resolution = parametre.getResolution().getNom().toLowerCase();
        double noteFinalValue;
        
        if (resolution.contains("plus petit")) {
            noteFinalValue = notes.stream().mapToDouble(Note::getNote).min().orElse(0);
        } else if (resolution.contains("plus grand")) {
            noteFinalValue = notes.stream().mapToDouble(Note::getNote).max().orElse(0);
        } else {
            noteFinalValue = notes.stream().mapToDouble(Note::getNote).average().orElse(0);
        }

        Optional<NoteFinal> existing = repository.findByMatiereAndCandidat(matiere, candidat);
        NoteFinal noteFinal = existing.orElse(new NoteFinal());
        noteFinal.setMatiere(matiere);
        noteFinal.setCandidat(candidat);
        noteFinal.setNote(noteFinalValue);

        return repository.save(noteFinal);
    }
}