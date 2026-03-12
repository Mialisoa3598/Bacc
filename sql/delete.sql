-- DELETE FROM t_note_finale;
-- DELETE FROM t_note;
-- DELETE FROM t_parametre;
-- DELETE FROM t_matiere;
-- DELETE FROM t_operateur;
-- DELETE FROM t_resolution;
-- DELETE FROM t_candidat;
-- DELETE FROM t_correcteur;

TRUNCATE TABLE 
t_note_finale,
t_note,
t_parametre,
t_matiere,
t_operateur,
t_resolution,
t_candidat,
t_correcteur
RESTART IDENTITY CASCADE;

TRUNCATE TABLE 
t_note_finale,
t_note,
t_parametre
RESTART IDENTITY CASCADE;