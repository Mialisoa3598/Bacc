package com.example.correction.service;

import com.example.correction.model.*;
import com.example.correction.repository.ParametreRepository;
import com.example.correction.repository.ResolutionRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParametreService {
    private final ParametreRepository repository;
    private final ResolutionRepository resolutionRepository;

    public ParametreService(ParametreRepository repository, 
                            ResolutionRepository resolutionRepository) {
        this.repository = repository;
        this.resolutionRepository = resolutionRepository;
    }


    public List<Parametre> findAll() { return repository.findAll(); }
    public Parametre findById(Long id) { return repository.findById(id).orElse(null); }
    public Parametre save(Parametre parametre) { return repository.save(parametre); }
    public void delete(Long id) { repository.deleteById(id); }

    public Parametre getParametre(Matiere matiere, double diff) {
        
        List<Parametre> params = repository.findByMatiere(matiere);
        for (Parametre p : params) {
            double seuil = p.getDiff();
            String operateur = p.getOperateur().getOperateur();
            if (eval(diff, operateur, seuil)) {
                return p;
            }
        }
        // Aucun parametre trouve => resolution = moyenne
        Parametre defaut = new Parametre();
        Resolution moyenne = resolutionRepository.findByNomIgnoreCase("moyenne")
                                .orElse(null);
        defaut.setResolution(moyenne);
        return defaut;
    }

    // Utility method to evaluate the comparison
    private boolean eval(double left, String operator, double right) {
        switch (operator) {
            case ">": return left > right;
            case "<": return left < right;
            case ">=": return left >= right;
            case "<=": return left <= right;
            case "==": return left == right;
            case "!=": return left != right;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}