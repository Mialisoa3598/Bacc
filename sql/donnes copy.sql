
TRUNCATE TABLE 
t_note_finale,
t_note,
t_parametre,
t_matiere,
t_operateur,
t_resolution,
t_candidat,
t_correcteur
RESTART IDENTITY;

INSERT INTO t_correcteur (nom) VALUES 
('Correcteur1'),
('Correcteur2'),
('Correcteur3');

INSERT INTO t_candidat (nom) VALUES 
('Candidat1'),
('Candidat2'),
('Candidat3');

INSERT INTO t_resolution (nom) VALUES 
('plus petit que'),
('plus grand que'),
('moyenne');

INSERT INTO t_operateur (operateur) VALUES 
('<'),
('<='),
('>'),
('>=');

INSERT INTO t_matiere (nom) VALUES 
('JAVA'),
('PHP');

INSERT INTO t_parametre (id_matiere, diff, id_operateur, id_resolution) VALUES 
(1, 5.0, 3, 2),  -- JAVA, diff > 5.0, plus grand que
(1, 8.0, 1, 1),  -- JAVA, diff < 8.0, plus petit que
-- PHP : seuils 4.0 et 7.0
(2, 4.0, 3, 2),  -- PHP, diff > 4.0, plus grand que
(2, 7.0, 1, 1);  -- PHP, diff < 7.0, plus petit que
 
INSERT INTO t_note (id_candidat, id_correcteur, id_matiere, note) VALUES 
(1, 1, 1, 10.0),
(1, 2, 1, 16.0),

-- Candidat2 JAVA : sommeDiff = 6.5 => egalite entre 5.0 et 8.0 => on prend 5.0
(2, 1, 1, 10.0),
(2, 2, 1, 17.0),

(3, 1, 1, 10.0),
(3, 2, 1, 16.5);
-- Candidat1 PHP : sommeDiff = 7.0 => plus proche de 7.0
-- (1, 1, 2, 10.0),
-- (1, 2, 2, 3.0);   -- |10-3| = 7.0
