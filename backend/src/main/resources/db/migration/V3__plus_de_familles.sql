-- Ajout de plus de classes
INSERT INTO classe (id, libelle, filiere, niveau) VALUES
('CL004', 'Sixieme A', 'General', 'Sixieme'),
('CL005', 'Cinquieme B', 'General', 'Cinquieme'),
('CL006', 'Quatrieme C', 'General', 'Quatrieme'),
('CL007', 'Troisieme A', 'General', 'Troisieme'),
('CL008', 'Premiere A', 'Litteraire', 'Premiere'),
('CL009', 'Terminale D', 'Scientifique', 'Terminale');

-- Famille NKOMO (3 enfants) - Pere: 671234567, Mere: 672345678
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU005', 'NKOMO', 'Grace', '2011-02-14', 'NKOMO Daniel', 'ATEBA Rose', '671234567', '672345678', 'CL004'),
('ETU006', 'NKOMO', 'Patrick', '2009-06-22', 'NKOMO Daniel', 'ATEBA Rose', '671234567', '672345678', 'CL007'),
('ETU007', 'NKOMO', 'Sylvie', '2007-11-30', 'NKOMO Daniel', 'ATEBA Rose', '671234567', '672345678', 'CL009');

-- Famille BIYA (2 enfants) - Pere: 673456789, Mere: 675678901
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU008', 'BIYA', 'Christian', '2010-03-15', 'BIYA Thomas', 'MANGA Cecile', '673456789', '675678901', 'CL005'),
('ETU009', 'BIYA', 'Nadine', '2008-09-08', 'BIYA Thomas', 'MANGA Cecile', '673456789', '675678901', 'CL003');

-- Famille ESSOMBA (4 enfants) - Pere: 676789012, Mere: 677890123
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU010', 'ESSOMBA', 'Joel', '2011-05-20', 'ESSOMBA Pierre', 'NDJOCK Marie', '676789012', '677890123', 'CL004'),
('ETU011', 'ESSOMBA', 'Beatrice', '2010-01-12', 'ESSOMBA Pierre', 'NDJOCK Marie', '676789012', '677890123', 'CL005'),
('ETU012', 'ESSOMBA', 'Samuel', '2009-07-25', 'ESSOMBA Pierre', 'NDJOCK Marie', '676789012', '677890123', 'CL006'),
('ETU013', 'ESSOMBA', 'Rachel', '2008-12-03', 'ESSOMBA Pierre', 'NDJOCK Marie', '676789012', '677890123', 'CL003');

-- Famille KAMGA (2 enfants) - Pere: 679012345, Mere: 680123456
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU014', 'KAMGA', 'Francois', '2009-04-18', 'KAMGA Andre', 'NJOYA Pauline', '679012345', '680123456', 'CL007'),
('ETU015', 'KAMGA', 'Juliette', '2010-08-22', 'KAMGA Andre', 'NJOYA Pauline', '679012345', '680123456', 'CL005');

-- Famille MBASSI (3 enfants) - Pere: 681234567, Mere: 683456789
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU016', 'MBASSI', 'Georges', '2011-01-10', 'MBASSI Jean', 'FOUDA Anne', '681234567', '683456789', 'CL004'),
('ETU017', 'MBASSI', 'Odette', '2009-05-15', 'MBASSI Jean', 'FOUDA Anne', '681234567', '683456789', 'CL006'),
('ETU018', 'MBASSI', 'Marcel', '2008-09-20', 'MBASSI Jean', 'FOUDA Anne', '681234567', '683456789', 'CL008');

-- Famille ONDOA (1 enfant) - Pere: 684567890, Mere: 685678901
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU019', 'ONDOA', 'Christelle', '2009-11-05', 'ONDOA Paul', 'BELLA Josephine', '684567890', '685678901', 'CL007');

-- Famille ABENA (2 enfants) - Pere: 686789012, Mere: 687890123
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU020', 'ABENA', 'Eric', '2010-02-28', 'ABENA Martin', 'MVONDO Claire', '686789012', '687890123', 'CL005'),
('ETU021', 'ABENA', 'Sandrine', '2008-07-14', 'ABENA Martin', 'MVONDO Claire', '686789012', '687890123', 'CL008');

-- Famille OWONA (3 enfants) - Pere: 688901234, Mere: 689012345
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU022', 'OWONA', 'Thierry', '2011-03-12', 'OWONA Jacques', 'EBOGO Francoise', '688901234', '689012345', 'CL004'),
('ETU023', 'OWONA', 'Vanessa', '2009-08-19', 'OWONA Jacques', 'EBOGO Francoise', '688901234', '689012345', 'CL006'),
('ETU024', 'OWONA', 'Boris', '2008-01-25', 'OWONA Jacques', 'EBOGO Francoise', '688901234', '689012345', 'CL009');

-- Famille NANGA (2 enfants) - Pere: 691234567, Mere: 692345678
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU025', 'NANGA', 'Diane', '2010-06-08', 'NANGA Robert', 'TCHOUA Brigitte', '691234567', '692345678', 'CL005'),
('ETU026', 'NANGA', 'Kevin', '2009-10-16', 'NANGA Robert', 'TCHOUA Brigitte', '691234567', '692345678', 'CL007');

-- Famille MBALLA (1 enfant) - Pere: 696789012, Mere: 697890123
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU027', 'MBALLA', 'Laure', '2009-04-30', 'MBALLA Simon', 'KONO Helene', '696789012', '697890123', 'CL006');

-- Famille NGONO (2 enfants) - Pere: 698901234, Mere: 699012345
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU028', 'NGONO', 'Alain', '2010-09-22', 'NGONO Charles', 'MEKA Sylvie', '698901234', '699012345', 'CL005'),
('ETU029', 'NGONO', 'Patricia', '2008-12-11', 'NGONO Charles', 'MEKA Sylvie', '698901234', '699012345', 'CL008');

-- Famille TCHUENTE (3 enfants) - Pere: 651234567, Mere: 652345678
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU030', 'TCHUENTE', 'Rodrigue', '2011-07-15', 'TCHUENTE Bernard', 'FEUDJIO Agnes', '651234567', '652345678', 'CL004'),
('ETU031', 'TCHUENTE', 'Stephanie', '2009-11-20', 'TCHUENTE Bernard', 'FEUDJIO Agnes', '651234567', '652345678', 'CL006'),
('ETU032', 'TCHUENTE', 'Yves', '2008-03-28', 'TCHUENTE Bernard', 'FEUDJIO Agnes', '651234567', '652345678', 'CL009');

-- Famille DJOUMESSI (2 enfants) - Pere: 654567890, Mere: 655678901
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU033', 'DJOUMESSI', 'Fabrice', '2010-05-07', 'DJOUMESSI Henri', 'TAGNE Monique', '654567890', '655678901', 'CL005'),
('ETU034', 'DJOUMESSI', 'Nathalie', '2009-02-14', 'DJOUMESSI Henri', 'TAGNE Monique', '654567890', '655678901', 'CL007');

-- Famille MOMO (3 enfants) - Pere: 656789012, Mere: 658901234
INSERT INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES
('ETU035', 'MOMO', 'Cedric', '2011-08-30', 'MOMO Francois', 'DJEUMO Beatrice', '656789012', '658901234', 'CL004'),
('ETU036', 'MOMO', 'Aurelie', '2010-01-18', 'MOMO Francois', 'DJEUMO Beatrice', '656789012', '658901234', 'CL005'),
('ETU037', 'MOMO', 'Lionel', '2008-06-25', 'MOMO Francois', 'DJEUMO Beatrice', '656789012', '658901234', 'CL008');
