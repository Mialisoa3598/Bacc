CREATE TABLE t_client (
    id_client SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    contact VARCHAR(255)
);

CREATE TABLE t_demande (
    id_demande SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    lieu VARCHAR(255),
    district VARCHAR(255),
    id_client INT NOT NULL,
    FOREIGN KEY (id_client) REFERENCES t_client(id_client)
);

CREATE TABLE t_status (
    id_status SERIAL PRIMARY KEY,
    libelle VARCHAR(255) NOT NULL
);

CREATE TABLE t_demande_status (
    id_demande_status SERIAL PRIMARY KEY,
    id_demande INT NOT NULL,
    id_status INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (id_demande) REFERENCES t_demande(id_demande),
    FOREIGN KEY (id_status) REFERENCES t_status(id_status)
);

CREATE TABLE t_type_devis (
    id_type_devis SERIAL PRIMARY KEY,
    libelle VARCHAR(255) NOT NULL
);

CREATE TABLE t_devis (
    id_devis SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    id_type_devis INT NOT NULL,
    id_demande INT NOT NULL,
    FOREIGN KEY (id_type_devis) REFERENCES t_type_devis(id_type_devis),
    FOREIGN KEY (id_demande) REFERENCES t_demande(id_demande),
    CONSTRAINT unique_demande_type UNIQUE (id_demande, id_type_devis)
);

CREATE TABLE t_detail_devis (
    id_detail_devis SERIAL PRIMARY KEY,
    libelle VARCHAR(255) NOT NULL,
    montant DECIMAL NOT NULL,
    id_devis INT NOT NULL,
    FOREIGN KEY (id_devis) REFERENCES t_devis(id_devis)
);

CREATE VIEW v_devis_total AS
SELECT 
    d.id_devis,
    td.libelle AS type_devis,
    SUM(dd.montant) AS montant_total
FROM t_devis d
JOIN t_type_devis td ON d.id_type_devis = td.id_type_devis
JOIN t_detail_devis dd ON dd.id_devis = d.id_devis
GROUP BY d.id_devis, td.libelle;