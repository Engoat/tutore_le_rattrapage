-- Ajout des emplois du temps pour toutes les classes
INSERT INTO emploi_du_temps (id, libelle, classe_id, pdf_url) VALUES
('EDT004', 'Emploi du temps Sixieme A 2025-2026', 'CL004', 'schedules/sixieme_a.pdf'),
('EDT005', 'Emploi du temps Cinquieme B 2025-2026', 'CL005', 'schedules/cinquieme_b.pdf'),
('EDT006', 'Emploi du temps Quatrieme C 2025-2026', 'CL006', 'schedules/quatrieme_c.pdf'),
('EDT007', 'Emploi du temps Troisieme A 2025-2026', 'CL007', 'schedules/troisieme_a.pdf'),
('EDT008', 'Emploi du temps Premiere A 2025-2026', 'CL008', 'schedules/premiere_a.pdf'),
('EDT009', 'Emploi du temps Terminale D 2025-2026', 'CL009', 'schedules/terminale_d.pdf');

-- Ajout des inscriptions pour tous les étudiants (Semestre 1)
-- Famille MBARGA
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS008', 'MAT101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS009', 'FRA101', 'ETU002', '2025-2026', 'Semestre 1'),
('INS010', 'ANG101', 'ETU002', '2025-2026', 'Semestre 1');

-- Famille NKOMO
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS011', 'MAT101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS012', 'FRA101', 'ETU005', '2025-2026', 'Semestre 1'),
('INS013', 'MAT101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS014', 'FRA101', 'ETU006', '2025-2026', 'Semestre 1'),
('INS015', 'PHY101', 'ETU007', '2025-2026', 'Semestre 1'),
('INS016', 'MAT101', 'ETU007', '2025-2026', 'Semestre 1');

-- Famille BIYA
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS017', 'MAT101', 'ETU008', '2025-2026', 'Semestre 1'),
('INS018', 'FRA101', 'ETU008', '2025-2026', 'Semestre 1'),
('INS019', 'PHY101', 'ETU009', '2025-2026', 'Semestre 1'),
('INS020', 'MAT101', 'ETU009', '2025-2026', 'Semestre 1');

-- Famille ESSOMBA (4 enfants)
INSERT INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES
('INS021', 'MAT101', 'ETU010', '2025-2026', 'Semestre 1'),
('INS022', 'FRA101', 'ETU010', '2025-2026', 'Semestre 1'),
('INS023', 'MAT101', 'ETU011', '2025-2026', 'Semestre 1'),
('INS024', 'FRA101', 'ETU011', '2025-2026', 'Semestre 1'),
('INS025', 'MAT101', 'ETU012', '2025-2026', 'Semestre 1'),
('INS026', 'FRA101', 'ETU012', '2025-2026', 'Semestre 1'),
('INS027', 'PHY101', 'ETU013', '2025-2026', 'Semestre 1'),
('INS028', 'MAT101', 'ETU013', '2025-2026', 'Semestre 1');

-- Ajout des notes pour le Semestre 1
-- ETU001 (Jean MBARGA) - Terminale C
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT012', 'INS001', 'Examen', 16.0, 'Mathematiques'),
('NOT013', 'INS002', 'Examen', 15.5, 'Physique'),
('NOT014', 'INS003', 'Examen', 14.0, 'Chimie');

-- ETU002 (Sophie MBARGA) - Seconde A
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT015', 'INS008', 'CC', 13.5, 'Mathematiques'),
('NOT016', 'INS008', 'Examen', 14.5, 'Mathematiques'),
('NOT017', 'INS009', 'CC', 15.0, 'Francais'),
('NOT018', 'INS009', 'Examen', 16.0, 'Francais'),
('NOT019', 'INS010', 'CC', 14.0, 'Anglais'),
('NOT020', 'INS010', 'Examen', 15.5, 'Anglais');

-- ETU003 (Emmanuel FOTSO) - Terminale C
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT021', 'INS006', 'Examen', 13.0, 'Mathematiques'),
('NOT022', 'INS007', 'Examen', 14.5, 'Physique');

-- ETU004 (Aline NGUEMA) - Premiere D
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT023', 'INS004', 'Examen', 15.5, 'Francais'),
('NOT024', 'INS005', 'Examen', 17.0, 'Anglais');

-- ETU005 (Grace NKOMO) - Sixieme A
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT025', 'INS011', 'CC', 12.0, 'Mathematiques'),
('NOT026', 'INS011', 'Examen', 13.5, 'Mathematiques'),
('NOT027', 'INS012', 'CC', 14.0, 'Francais'),
('NOT028', 'INS012', 'Examen', 15.0, 'Francais');

-- ETU006 (Patrick NKOMO) - Troisieme A
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT029', 'INS013', 'CC', 15.0, 'Mathematiques'),
('NOT030', 'INS013', 'Examen', 16.0, 'Mathematiques'),
('NOT031', 'INS014', 'CC', 13.5, 'Francais'),
('NOT032', 'INS014', 'Examen', 14.5, 'Francais');

-- ETU007 (Sylvie NKOMO) - Terminale D
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT033', 'INS015', 'CC', 17.0, 'Physique'),
('NOT034', 'INS015', 'Examen', 18.0, 'Physique'),
('NOT035', 'INS016', 'CC', 16.5, 'Mathematiques'),
('NOT036', 'INS016', 'Examen', 17.5, 'Mathematiques');

-- ETU008 (Christian BIYA) - Cinquieme B
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT037', 'INS017', 'CC', 11.0, 'Mathematiques'),
('NOT038', 'INS017', 'Examen', 12.5, 'Mathematiques'),
('NOT039', 'INS018', 'CC', 13.0, 'Francais'),
('NOT040', 'INS018', 'Examen', 14.0, 'Francais');

-- ETU009 (Nadine BIYA) - Premiere D
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT041', 'INS019', 'CC', 14.5, 'Physique'),
('NOT042', 'INS019', 'Examen', 15.5, 'Physique'),
('NOT043', 'INS020', 'CC', 15.0, 'Mathematiques'),
('NOT044', 'INS020', 'Examen', 16.0, 'Mathematiques');

-- Famille ESSOMBA (4 enfants)
-- ETU010 (Joel ESSOMBA) - Sixieme A
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT045', 'INS021', 'CC', 13.0, 'Mathematiques'),
('NOT046', 'INS021', 'Examen', 14.0, 'Mathematiques'),
('NOT047', 'INS022', 'CC', 12.5, 'Francais'),
('NOT048', 'INS022', 'Examen', 13.5, 'Francais');

-- ETU011 (Beatrice ESSOMBA) - Cinquieme B
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT049', 'INS023', 'CC', 15.5, 'Mathematiques'),
('NOT050', 'INS023', 'Examen', 16.5, 'Mathematiques'),
('NOT051', 'INS024', 'CC', 14.0, 'Francais'),
('NOT052', 'INS024', 'Examen', 15.0, 'Francais');

-- ETU012 (Samuel ESSOMBA) - Quatrieme C
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT053', 'INS025', 'CC', 12.0, 'Mathematiques'),
('NOT054', 'INS025', 'Examen', 13.0, 'Mathematiques'),
('NOT055', 'INS026', 'CC', 13.5, 'Francais'),
('NOT056', 'INS026', 'Examen', 14.5, 'Francais');

-- ETU013 (Rachel ESSOMBA) - Premiere D
INSERT INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES
('NOT057', 'INS027', 'CC', 16.0, 'Physique'),
('NOT058', 'INS027', 'Examen', 17.0, 'Physique'),
('NOT059', 'INS028', 'CC', 15.5, 'Mathematiques'),
('NOT060', 'INS028', 'Examen', 16.5, 'Mathematiques');
