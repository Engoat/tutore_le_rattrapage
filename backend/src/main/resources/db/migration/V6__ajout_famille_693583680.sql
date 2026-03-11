-- Migration V6: Ajout de la famille avec le numéro 693583680

-- Ajouter les 2 enfants de la famille NGUEMA avec le père 693583680
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES 
('ETU005', 'NGUEMA', 'Alice', '2008-03-15', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677445566', 'CL003'),
('ETU006', 'NGUEMA', 'David', '2007-11-20', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677556677', 'CL001');

-- Ajouter les inscriptions pour Alice (Première D)
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS008', 'MAT101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS009', 'PHY101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS010', 'CHI101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS011', 'FRA101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS012', 'ANG101', 'ETU005', '2025-2026', 'Semestre 1');

-- Ajouter les inscriptions pour David (Terminale C)
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS013', 'MAT101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS014', 'PHY101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS015', 'CHI101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS016', 'FRA101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS017', 'PHI101', 'ETU006', '2025-2026', 'Semestre 1');

-- Ajouter quelques notes pour Alice (Première D) - bonnes notes
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES 
('NOT012', 'INS008', 'CC', 15.5, 'Mathematiques'),
('NOT013', 'INS008', 'SN', 14.0, 'Mathematiques'),
('NOT014', 'INS009', 'CC', 16.0, 'Physique'),
('NOT015', 'INS009', 'TP', 15.5, 'Physique'),
('NOT016', 'INS010', 'CC', 14.5, 'Chimie'),
('NOT017', 'INS010', 'SN', 13.0, 'Chimie'),
('NOT018', 'INS011', 'CC', 13.5, 'Francais'),
('NOT019', 'INS011', 'SN', 12.0, 'Francais'),
('NOT020', 'INS012', 'CC', 16.0, 'Anglais');

-- Ajouter quelques notes pour David (Terminale C) - très bonnes notes
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES 
('NOT021', 'INS013', 'CC', 17.0, 'Mathematiques'),
('NOT022', 'INS013', 'SN', 16.5, 'Mathematiques'),
('NOT023', 'INS014', 'CC', 18.0, 'Physique'),
('NOT024', 'INS014', 'TP', 17.5, 'Physique'),
('NOT025', 'INS015', 'CC', 16.0, 'Chimie'),
('NOT026', 'INS015', 'SN', 15.5, 'Chimie'),
('NOT027', 'INS016', 'CC', 14.0, 'Francais'),
('NOT028', 'INS016', 'SN', 15.5, 'Francais'),
('NOT029', 'INS017', 'CC', 13.5, 'Philosophie');