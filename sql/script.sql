-- CREATE DATABASE db_double_correction;
-- \c db_double_correction;

CREATE TABLE t_correcteur (
    id_correcteur SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE t_candidat (
    id_candidat SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE t_resolution (
    id_resolution SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE t_operateur (
    id_operateur SERIAL PRIMARY KEY,
    operateur VARCHAR(255) NOT NULL
);

CREATE TABLE t_matiere (
    id_matiere SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

CREATE TABLE t_parametre (
    id_parametre SERIAL PRIMARY KEY,
    id_matiere INT NOT NULL,
    diff DECIMAL NOT NULL,
    id_operateur INT NOT NULL,
    id_resolution INT NOT NULL,
    FOREIGN KEY (id_matiere) REFERENCES t_matiere(id_matiere),
    FOREIGN KEY (id_operateur) REFERENCES t_operateur(id_operateur),
    FOREIGN KEY (id_resolution) REFERENCES t_resolution(id_resolution)
);


CREATE TABLE t_note (
    id_note SERIAL PRIMARY KEY,
    id_candidat INT NOT NULL,
    id_matiere INT NOT NULL,
    id_correcteur INT NOT NULL,
    note DECIMAL NOT NULL,
    FOREIGN KEY (id_candidat) REFERENCES t_candidat(id_candidat),
    FOREIGN KEY (id_matiere) REFERENCES t_matiere(id_matiere),
    FOREIGN KEY (id_correcteur) REFERENCES t_correcteur(id_correcteur)
);

CREATE TABLE t_note_finale (
    id_note_finale SERIAL PRIMARY KEY,
    id_candidat INT NOT NULL,
    id_matiere INT NOT NULL,
    note_finale DECIMAL NOT NULL,
    FOREIGN KEY (id_candidat) REFERENCES t_candidat(id_candidat),
    FOREIGN KEY (id_matiere) REFERENCES t_matiere(id_matiere)
);