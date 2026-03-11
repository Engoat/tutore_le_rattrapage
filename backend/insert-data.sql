-- Script pour insérer les données de test dans la base suivi_academique_clean

-- Insertion des classes
INSERT INTO classe (id, libelle, filiere, niveau) VALUES
('CL001', 'Terminale C', 'Scientifique', 'Terminale'),
('CL002', 'Seconde A', 'Litteraire', 'Seconde'),
('CL003', 'Premiere D', 'Scientifique', 'Premiere'),
('CL004', 'Premiere S', 'Scientifique', 'Premiere'),
('CL005', 'Terminale D', 'Scientifique', 'Terminale'),
('CL006', 'Seconde C', 'Scientifique', 'Seconde');

-- Insertion des étudiants avec numéros camerounais valides
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
-- Famille NGUEMA (3 enfants) - Pere: 693583680 (TON NUMERO) ⭐
('ETU001', 'NGUEMA', 'Alice', '2008-03-15', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677445566', 'CL003'),
('ETU002', 'NGUEMA', 'David', '2007-11-20', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677556677', 'CL001'),
('ETU003', 'NGUEMA', 'Sarah', '2009-07-10', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677445566', 'CL002'),

-- Famille MBARGA (2 enfants) - Pere: 693147445
('ETU004', 'MBARGA', 'Jean', '2008-05-15', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL001'),
('ETU005', 'MBARGA', 'Sophie', '2010-08-20', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL002'),

-- Famille FOTSO (3 enfants) - Pere: 677123456
('ETU006', 'FOTSO', 'Emmanuel', '2009-03-10', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL004'),
('ETU007', 'FOTSO', 'Grace', '2008-12-05', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL005'),
('ETU008', 'FOTSO', 'Michel', '2010-09-18', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL006'),

-- Famille ESSOMBA (4 enfants) - Pere: 676789012
('ETU009', 'ESSOMBA', 'Carole', '2007-06-22', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL005'),
('ETU010', 'ESSOMBA', 'Patrick', '2008-04-14', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL003'),
('ETU011', 'ESSOMBA', 'Nadine', '2009-11-30', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL004'),
('ETU012', 'ESSOMBA', 'Kevin', '2010-02-17', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL006'),

-- Famille NKOMO (2 enfants) - Pere: 671234567
('ETU013', 'NKOMO', 'Vanessa', '2008-08-11', 'NKOMO Joseph', 'BIYA Claire', '671234567', '672345678', 'CL001'),
('ETU014', 'NKOMO', 'Boris', '2009-05-25', 'NKOMO Joseph', 'BIYA Claire', '671234567', '672345678', 'CL002'),

-- Famille TALLA (3 enfants) - Pere: 680123456
('ETU015', 'TALLA', 'Diane', '2007-10-03', 'TALLA Martin', 'OWONA Beatrice', '680123456', '681234567', 'CL005'),
('ETU016', 'TALLA', 'Frank', '2008-01-19', 'TALLA Martin', 'OWONA Beatrice', '680123456', '681234567', 'CL003'),
('ETU017', 'TALLA', 'Linda', '2010-06-08', 'TALLA Martin', 'OWONA Beatrice', '680123456', '681234567', 'CL006'),

-- Famille BELLO (2 enfants) - Pere: 694567890
('ETU018', 'BELLO', 'Armand', '2008-09-12', 'BELLO Samuel', 'MANGA Estelle', '694567890', '695678901', 'CL004'),
('ETU019', 'BELLO', 'Christelle', '2009-12-07', 'BELLO Samuel', 'MANGA Estelle', '694567890', '695678901', 'CL002');

-- Insertion des inscriptions
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
-- Inscriptions pour Alice NGUEMA (Première D)
('INS001', 'MAT101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS002', 'PHY101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS003', 'CHI101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS004', 'FRA101', 'ETU001', '2025-2026', 'Semestre 1'),
('INS005', 'ANG101', 'ETU001', '2025-2026', 'Semestre 1'),

-- Inscriptions pour David NGUEMA (Terminale C)
('INS006', 'MAT101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS007', 'PHY101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS008', 'CHI101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS009', 'FRA101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS010', 'PHI101', 'ETU002', '2025-2026', 'Semestre 1'),

-- Inscriptions pour Sarah NGUEMA (Seconde A)
('INS011', 'MAT101', 'ETU003', '2025-2026', 'Semestre 1'),
('INS012', 'FRA101', 'ETU003', '2025-2026', 'Semestre 1'),
('INS013', 'ANG101', 'ETU003', '2025-2026', 'Semestre 1'),
('INS014', 'HIS101', 'ETU003', '2025-2026', 'Semestre 1'),

-- Inscriptions pour Jean MBARGA (Terminale C)
('INS015', 'MAT101', 'ETU004', '2025-2026', 'Semestre 1'),
('INS016', 'PHY101', 'ETU004', '2025-2026', 'Semestre 1'),
('INS017', 'CHI101', 'ETU004', '2025-2026', 'Semestre 1'),

-- Inscriptions pour Sophie MBARGA (Seconde A)
('INS018', 'FRA101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS019', 'ANG101', 'ETU005', '2025-2026', 'Semestre 1'),

-- Inscriptions pour Emmanuel FOTSO (Première S)
('INS020', 'MAT101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS021', 'PHY101', 'ETU006', '2025-2026', 'Semestre 1'),

-- Inscriptions pour les autres étudiants
('INS022', 'MAT101', 'ETU007', '2025-2026', 'Semestre 1'),
('INS023', 'MAT101', 'ETU009', '2025-2026', 'Semestre 1'),
('INS024', 'PHY101', 'ETU010', '2025-2026', 'Semestre 1'),
('INS025', 'MAT101', 'ETU013', '2025-2026', 'Semestre 1'),
('INS026', 'FRA101', 'ETU014', '2025-2026', 'Semestre 1'),
('INS027', 'MAT101', 'ETU015', '2025-2026', 'Semestre 1'),
('INS028', 'PHY101', 'ETU016', '2025-2026', 'Semestre 1'),
('INS029', 'MAT101', 'ETU018', '2025-2026', 'Semestre 1'),
('INS030', 'FRA101', 'ETU019', '2025-2026', 'Semestre 1');

-- Insertion des notes
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
-- Notes pour Alice NGUEMA (bonnes notes)
('NOT001', 'INS001', 'CC', 15.5, 'Mathematiques'),
('NOT002', 'INS001', 'SN', 14.0, 'Mathematiques'),
('NOT003', 'INS002', 'CC', 16.0, 'Physique'),
('NOT004', 'INS002', 'TP', 15.5, 'Physique'),
('NOT005', 'INS003', 'CC', 14.5, 'Chimie'),
('NOT006', 'INS003', 'SN', 13.0, 'Chimie'),
('NOT007', 'INS004', 'CC', 13.5, 'Francais'),
('NOT008', 'INS004', 'SN', 12.0, 'Francais'),
('NOT009', 'INS005', 'CC', 16.0, 'Anglais'),

-- Notes pour David NGUEMA (excellentes notes)
('NOT010', 'INS006', 'CC', 17.0, 'Mathematiques'),
('NOT011', 'INS006', 'SN', 16.5, 'Mathematiques'),
('NOT012', 'INS007', 'CC', 18.0, 'Physique'),
('NOT013', 'INS007', 'TP', 17.5, 'Physique'),
('NOT014', 'INS008', 'CC', 16.0, 'Chimie'),
('NOT015', 'INS008', 'SN', 15.5, 'Chimie'),
('NOT016', 'INS009', 'CC', 14.0, 'Francais'),
('NOT017', 'INS009', 'SN', 15.5, 'Francais'),
('NOT018', 'INS010', 'CC', 13.5, 'Philosophie'),

-- Notes pour Sarah NGUEMA (notes moyennes)
('NOT019', 'INS011', 'CC', 12.5, 'Mathematiques'),
('NOT020', 'INS011', 'SN', 11.0, 'Mathematiques'),
('NOT021', 'INS012', 'CC', 13.0, 'Francais'),
('NOT022', 'INS012', 'SN', 14.5, 'Francais'),
('NOT023', 'INS013', 'CC', 15.0, 'Anglais'),
('NOT024', 'INS014', 'CC', 12.0, 'Histoire'),

-- Notes pour Jean MBARGA
('NOT025', 'INS015', 'CC', 15.5, 'Mathematiques'),
('NOT026', 'INS015', 'SN', 14.0, 'Mathematiques'),
('NOT027', 'INS016', 'CC', 16.0, 'Physique'),
('NOT028', 'INS016', 'TP', 17.5, 'Physique'),
('NOT029', 'INS017', 'CC', 13.5, 'Chimie'),

-- Notes pour Sophie MBARGA
('NOT030', 'INS018', 'CC', 14.5, 'Francais'),
('NOT031', 'INS018', 'SN', 15.0, 'Francais'),
('NOT032', 'INS019', 'CC', 16.5, 'Anglais'),

-- Notes pour Emmanuel FOTSO
('NOT033', 'INS020', 'CC', 14.0, 'Mathematiques'),
('NOT034', 'INS020', 'SN', 13.5, 'Mathematiques'),
('NOT035', 'INS021', 'CC', 15.5, 'Physique'),

-- Notes pour les autres étudiants (quelques exemples)
('NOT036', 'INS022', 'CC', 16.0, 'Mathematiques'),
('NOT037', 'INS023', 'CC', 17.5, 'Mathematiques'),
('NOT038', 'INS024', 'CC', 14.5, 'Physique'),
('NOT039', 'INS025', 'CC', 15.0, 'Mathematiques'),
('NOT040', 'INS026', 'CC', 13.5, 'Francais'),
('NOT041', 'INS027', 'CC', 16.5, 'Mathematiques'),
('NOT042', 'INS028', 'CC', 15.5, 'Physique'),
('NOT043', 'INS029', 'CC', 14.0, 'Mathematiques'),
('NOT044', 'INS030', 'CC', 13.0, 'Francais');

-- Insertion des emplois du temps
INSERT INTO emploi_du_temps (id, libelle, classe_id, pdf_url) VALUES
('EDT001', 'Emploi du temps Terminale C 2025-2026', 'CL001', 'schedules/terminale_c.pdf'),
('EDT002', 'Emploi du temps Seconde A 2025-2026', 'CL002', 'schedules/seconde_a.pdf'),
('EDT003', 'Emploi du temps Premiere D 2025-2026', 'CL003', 'schedules/premiere_d.pdf'),
('EDT004', 'Emploi du temps Premiere S 2025-2026', 'CL004', 'schedules/premiere_s.pdf'),
('EDT005', 'Emploi du temps Terminale D 2025-2026', 'CL005', 'schedules/terminale_d.pdf'),
('EDT006', 'Emploi du temps Seconde C 2025-2026', 'CL006', 'schedules/seconde_c.pdf');