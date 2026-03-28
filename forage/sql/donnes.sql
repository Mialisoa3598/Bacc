INSERT INTO t_client (nom, contact) VALUES
('Client1', '034 00 000 01'),
('Client2', '034 00 000 02');

-- INSERT INTO t_status (libelle) VALUES
-- ('cree'),
-- ('accepte'),
-- ('refuse'),
-- ('commence'),
-- ('termine');

INSERT INTO t_status (libelle) VALUES
('accepte'),
('cree'),
('refuse'),
('commence'),
('termine'),
('devis etude cree'),
('devis forage cree');

INSERT INTO t_type_devis (libelle) VALUES
('Etude'),
('Forage');

INSERT INTO t_demande (date, lieu, district, id_client) VALUES
('2026-01-01', 'Antananarivo', 'Analamanga', 1),
('2026-01-15', 'Fianarantsoa', 'Matsiatra', 2);

INSERT INTO t_demande_status (id_demande, id_status, date) VALUES
(1, 1, '2026-01-02'),  -- Demande1 acceptee
(1, 3, '2026-01-05'),  -- Demande1 commencee
(2, 1, '2026-01-16'); -- Demande2 acceptee

INSERT INTO t_devis (date, id_type_devis, id_demande) VALUES
('2026-01-03', 1, 1),  -- Devis etude terrain pour Demande1
('2026-01-06', 2, 1),  -- Devis forage pour Demande1
('2026-01-17', 1, 2);  -- Devis etude terrain pour Demande2

INSERT INTO t_detail_devis (libelle, montant, id_devis) VALUES
('Main d''oeuvre etude', 200000, 1),
('Transport etude', 50000, 1),
('Forage 50m', 1500000, 2),
('Materiel forage', 300000, 2),
('Main d''oeuvre forage', 500000, 2),
('Main d''oeuvre etude', 150000, 3),
('Transport etude', 50000, 3);