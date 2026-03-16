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

    public Parametre getParametre_0(Matiere matiere, double diff) {
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

    public Parametre getParametre(Matiere matiere, double diff) {
        List<Parametre> params = repository.findByMatiereOrderByDiffAsc(matiere);
        Parametre meilleur = null;
        double meilleureDistance = Double.MAX_VALUE;
        for (Parametre p : params) {
            double distance = Math.abs(diff - p.getDiff());
            if (distance < meilleureDistance) {
                meilleur = p;
                meilleureDistance = distance;
            }
        }
        if (meilleur == null) {
            Parametre defaut = new Parametre();
            Resolution moyenne = resolutionRepository.findByNomIgnoreCase("moyenne").orElse(null);
            defaut.setResolution(moyenne);
            return defaut;
        }
        return meilleur;
    }

    // public Parametre getParametre(Matiere matiere, double diff) {
    //     List<Parametre> params = repository.findByMatiere(matiere);
        
    //     Parametre meilleur = null;
    //     double meilleureDistance = Double.MAX_VALUE; // on commence avec une distance "infinie"

    //     for (Parametre p : params) {
    //         double distance = Math.abs(diff - p.getDiff());
            
    //         if (meilleur == null) {
    //             // premier parametre, on le prend par defaut
    //             meilleur = p;
    //             meilleureDistance = distance;
    //         } else if (distance < meilleureDistance) {
    //             // ce parametre est plus proche => il devient le meilleur
    //             meilleur = p;
    //             meilleureDistance = distance;
    //         } else if (distance == meilleureDistance && p.getDiff() < meilleur.getDiff()) {
    //             // egalite de distance => on prend le seuil le plus petit
    //             meilleur = p;
    //         }
    //     }

    //     // si aucun parametre trouve => resolution = moyenne
    //     if (meilleur == null) {
    //         Parametre defaut = new Parametre();
    //         Resolution moyenne = resolutionRepository.findByNomIgnoreCase("moyenne").orElse(null);
    //         defaut.setResolution(moyenne);
    //         return defaut;
    //     }

    //     return meilleur;
    // }


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