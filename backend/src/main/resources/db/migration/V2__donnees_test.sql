-- Insertion des classes
INSERT INTO classe (id, libelle, filiere, niveau) VALUES
('CL001', 'Terminale C', 'Scientifique', 'Terminale'),
('CL002', 'Seconde A', 'Litteraire', 'Seconde'),
('CL003', 'Premiere D', 'Scientifique', 'Premiere');

-- Insertion des etudiants avec numeros camerounais valides
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
-- Famille MBARGA (2 enfants) - Pere: 693147445, Mere: 675234567
('ETU001', 'MBARGA', 'Jean', '2008-05-15', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL001'),
('ETU002', 'MBARGA', 'Sophie', '2010-08-20', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL002'),
-- Famille FOTSO (1 enfant) - Pere: 677123456, Mere: 678234567
('ETU003', 'FOTSO', 'Emmanuel', '2009-03-10', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL001'),
-- Famille NGUEMA (1 enfant) - Pere: 680345678, Mere: 681456789
('ETU004', 'NGUEMA', 'Aline', '2009-11-25', 'NGUEMA Joseph', 'ESSOMBA Claire', '680345678', '681456789', 'CL003');

-- Insertion des inscriptions
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS001', 'MAT101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS002', 'PHY101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS003', 'CHI101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS004', 'FRA101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS005', 'ANG101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS006', 'MAT101', 'ETU003', '2025-2026', 'Semestre 1'),
('INS007', 'PHY101', 'ETU003', '2025-2026', 'Semestre 1');

-- Insertion des notes
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT001', 'INS001', 'CC', 15.5, 'Mathematiques'),
('NOT002', 'INS001', 'SN', 14.0, 'Mathematiques'),
('NOT003', 'INS002', 'CC', 16.0, 'Physique'),
('NOT004', 'INS002', 'TP', 17.5, 'Physique'),
('NOT005', 'INS003', 'CC', 13.5, 'Chimie'),
('NOT006', 'INS003', 'SN', 12.0, 'Chimie'),
('NOT007', 'INS004', 'CC', 14.5, 'Francais'),
('NOT008', 'INS004', 'SN', 15.0, 'Francais'),
('NOT009', 'INS005', 'CC', 16.5, 'Anglais'),
('NOT010', 'INS006', 'CC', 14.0, 'Mathematiques'),
('NOT011', 'INS007', 'CC', 15.5, 'Physique');

-- Insertion des emplois du temps
INSERT INTO emploi_du_temps (id, libelle, classe_id, pdf_url) VALUES
('EDT001', 'Emploi du temps Terminale C 2025-2026', 'CL001', 'schedules/terminale_c.pdf'),
('EDT002', 'Emploi du temps Seconde A 2025-2026', 'CL002', 'schedules/seconde_a.pdf'),
('EDT003', 'Emploi du temps Premiere D 2025-2026', 'CL003', 'schedules/premiere_d.pdf');
