INSERT INTO t_correcteur (nom) VALUES 
('Correcteur1'),
('Correcteur2'),
('Correcteur3');

INSERT INTO t_candidat (nom) VALUES 
('Candidat1'),
('Candidat2');

INSERT INTO t_resolution (nom) VALUES 
('plus petit que'),
('plus grand que'),
('moyenne');

INSERT INTO t_operateur (operateur) VALUES 
('<'),
('>');

INSERT INTO t_matiere (nom) VALUES 
('Mathematiques'),
('Chimie');

INSERT INTO t_parametre (id_matiere, diff, id_operateur, id_resolution) VALUES 
(1, 5.0, 1, 2),
(1, 5.0, 2, 1),
(2, 4.0, 1, 2),
(2, 4.0, 2, 1);
 
INSERT INTO t_note (id_candidat, id_correcteur, id_matiere, note) VALUES 
(1, 1, 1, 7.5),
(1, 2, 1, 6.0),
(2, 1, 2, 13.0),
(2, 2, 2, 9.0),
(2, 3, 2, 8.0);
