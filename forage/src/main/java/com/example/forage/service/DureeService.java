package com.example.forage.service;

import com.example.forage.model.*;
import com.example.forage.repository.*;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
// import java.util.List;

@Service
public class DureeService {

    private final ParametreTravailRepository parametreTravailRepository;
    private final JourExceptionRepository jourExceptionRepository;

    public DureeService(ParametreTravailRepository parametreTravailRepository,
                        JourExceptionRepository jourExceptionRepository) {
        this.parametreTravailRepository = parametreTravailRepository;
        this.jourExceptionRepository = jourExceptionRepository;
    }

    // =============================================
    // APPROCHE 1 : Simple — Duration.between()
    // Retourne la duree en minutes entre deux dates
    // =============================================
    public Integer calculerDureeSimple(LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null) return null;
        return (int) Duration.between(debut, fin).toMinutes();
    }

    // =============================================
    // APPROCHE 2 : Complexe — exclure week-ends,
    // heures hors plage et jours exceptionnels
    // =============================================
    public Integer calculerDureeComplexe(LocalDateTime debut, LocalDateTime fin) {
        if (debut == null || fin == null) return null;

        // Recuperer les parametres globaux
        ParametreTravail param = parametreTravailRepository.findAll()
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Parametre travail introuvable !"));

        LocalTime heureDebut = param.getHeureDebut(); // ex: 08:00
        LocalTime heureFin = param.getHeureFin();     // ex: 17:00

        int totalMinutes = 0;
        LocalDateTime current = debut;

        // On avance minute par minute de debut jusqu'a fin
        while (current.isBefore(fin)) {
            if (estMinuteTravaillee(current, param, heureDebut, heureFin)) {
                totalMinutes++;
            }
            current = current.plusMinutes(1);
        }

        return totalMinutes;
    }

    // Verifie si une minute donnee est travaillee
    private boolean estMinuteTravaillee(LocalDateTime moment,
                                         ParametreTravail param,
                                         LocalTime heureDebut,
                                         LocalTime heureFin) {
        LocalDate date = moment.toLocalDate();
        LocalTime heure = moment.toLocalTime();
        DayOfWeek jour = date.getDayOfWeek();

        // Verifier si c'est un week-end non travaille
        if (jour == DayOfWeek.SATURDAY && !param.getTravailSamedi()) return false;
        if (jour == DayOfWeek.SUNDAY && !param.getTravailDimanche()) return false;

        // Verifier si c'est un jour exceptionnel
        if (jourExceptionRepository.existsByDateException(date)) return false;

        // Verifier si l'heure est dans la plage de travail
        if (heure.isBefore(heureDebut) || !heure.isBefore(heureFin)) return false;

        return true;
    }

    // Formatter les minutes en "Xh Ymin" pour l'affichage
    public String formatterDuree(Integer minutes) {
        if (minutes == null) return "-";
        int heures = minutes / 60;
        int mins = minutes % 60;
        if (heures == 0) return mins + "min";
        if (mins == 0) return heures + "h";
        return heures + "h " + mins + "min";
    }
}