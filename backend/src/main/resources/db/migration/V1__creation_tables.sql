-- Creation de la table classe
CREATE TABLE classe (
    id VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL,
    filiere VARCHAR(100),
    niveau VARCHAR(50)
);

-- Creation de la table etudiant
CREATE TABLE etudiant (
    matricule VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE,
    nom_pere VARCHAR(100),
    nom_mere VARCHAR(100),
    telephone_pere VARCHAR(200),
    telephone_mere VARCHAR(200),
    classe_id VARCHAR(50),
    FOREIGN KEY (classe_id) REFERENCES classe(id)
);

-- Creation de la table inscription
CREATE TABLE inscription (
    id VARCHAR(50) PRIMARY KEY,
    code_ue VARCHAR(50) NOT NULL,
    matricule_etudiant VARCHAR(50) NOT NULL,
    annee_academique VARCHAR(20) NOT NULL,
    semestre VARCHAR(20) NOT NULL,
    FOREIGN KEY (matricule_etudiant) REFERENCES etudiant(matricule)
);

-- Creation de la table note
CREATE TABLE note (
    id VARCHAR(50) PRIMARY KEY,
    inscription_id VARCHAR(50) NOT NULL,
    type_evaluation VARCHAR(10) NOT NULL,
    valeur_note DECIMAL(5,2),
    libelle_matiere VARCHAR(200) NOT NULL,
    FOREIGN KEY (inscription_id) REFERENCES inscription(id)
);

-- Creation de la table emploi_du_temps
CREATE TABLE emploi_du_temps (
    id VARCHAR(50) PRIMARY KEY,
    libelle VARCHAR(200),
    classe_id VARCHAR(50) UNIQUE,
    pdf_url VARCHAR(500),
    FOREIGN KEY (classe_id) REFERENCES classe(id)
);

-- Creation de la table stockage_otp
CREATE TABLE stockage_otp (
    numero_telephone VARCHAR(100) PRIMARY KEY,
    code_otp VARCHAR(10) NOT NULL,
    cree_le TIMESTAMP NULL,
    expire_le TIMESTAMP NULL
);

-- Index pour ameliorer les performances
CREATE INDEX idx_etudiant_telephone_pere ON etudiant(telephone_pere);
CREATE INDEX idx_etudiant_telephone_mere ON etudiant(telephone_mere);
CREATE INDEX idx_note_inscription ON note(inscription_id);
CREATE INDEX idx_inscription_etudiant ON inscription(matricule_etudiant);
