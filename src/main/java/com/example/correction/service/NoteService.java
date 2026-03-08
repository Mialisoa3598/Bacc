package com.example.correction.service;

import com.example.correction.model.Note;
import com.example.correction.model.Matiere;
import com.example.correction.model.Candidat;
import com.example.correction.repository.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> findAll() { 
        return repository.findAll(); 

    }
    public Note findById(Long id) { 
        return repository.findById(id).orElse(null); 

    }
    public Note save(Note note) { 
        return repository.save(note); 

    }
    public void delete(Long id) { 
        repository.deleteById(id); 

    }

    public List<Note> getNotes(Matiere matiere, Candidat candidat) {
        return repository.findByMatiereAndCandidat(matiere, candidat);
    }

    public double calculSommeDifference(Matiere matiere, Candidat candidat) {
        List<Note> notes = getNotes(matiere, candidat);
        double somme = 0;
        for (int i = 0; i < notes.size(); i++) {
            for (int j = i + 1; j < notes.size(); j++) {
                double diff = Math.abs(notes.get(i).getNote() - notes.get(j).getNote());
                somme += diff;
            }
        }
        return somme;
    }
}