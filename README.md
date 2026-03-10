# Rattrapo Tutore - Plateforme de Suivi Academique

Plateforme web de suivi academique pour le College Rattrapo permettant aux parents de consulter les informations scolaires de leurs enfants via authentification OTP par SMS.

## Fonctionnalites

- Authentification securisee par OTP (SMS)
- Consultation des informations des enfants
- Visualisation des notes par semestre avec moyennes
- Acces aux emplois du temps des classes
- Interface responsive et moderne
- Support des numeros camerounais (tous formats)

## Technologies

### Backend
- Spring Boot 3.2.0
- Java 17
- MySQL 5.5+
- Flyway (migrations)
- JWT (authentification)
- Maven

### Frontend
- HTML5 / CSS3 / JavaScript
- Design moderne et responsive
- Aucune dependance externe

## Installation

### Prerequis
- Java 17 ou superieur
- MySQL 5.5 ou superieur
- Maven 3.6+

### Configuration de la base de donnees

1. Creer la base de donnees:
```sql
CREATE DATABASE suivi_academique CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Configurer les identifiants dans `backend/src/main/resources/application.properties`

### Lancement

1. Demarrer le backend:
```bash
cd backend
mvn spring-boot:run
```

2. Ouvrir le frontend:
```
Ouvrir frontend/index.html dans un navigateur
```

## Utilisation

### Connexion
1. Entrer un numero de telephone camerounais
2. Recevoir le code OTP (visible dans les logs du backend en mode dev)
3. Valider le code
4. Consulter les informations des enfants

### Numeros de test

| Numero | Famille | Enfants |
|--------|---------|---------|
| 693147445 | MBARGA | 2 |
| 676789012 | ESSOMBA | 4 |
| 671234567 | NKOMO | 3 |

Formats acceptes: `693147445`, `+237693147445`, `+237 693 147 445`

## Structure du projet

```
rattrapo_tutore/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── cm/institutsaintjean/suiviacademique/
│   │   │   │       ├── config/
│   │   │   │       ├── controleurs/
│   │   │   │       ├── dto/
│   │   │   │       ├── entites/
│   │   │   │       ├── repositories/
│   │   │   │       └── services/
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── db/migration/
│   │   └── test/
│   └── pom.xml
├── frontend/
│   ├── index.html
│   └── schedules/
└── README.md
```

## Donnees de test

Le systeme contient:
- 17 familles
- 37 etudiants
- 9 classes
- Notes pour 13 etudiants (Semestre 1)
- Emplois du temps pour toutes les classes

## API Endpoints

### Authentification
- `POST /api/auth/envoyer-otp` - Envoyer un code OTP
- `POST /api/auth/verifier-otp` - Verifier le code OTP

### Etudiants
- `GET /api/etudiants/mes-enfants` - Liste des enfants
- `GET /api/etudiants/{matricule}/notes` - Notes d'un etudiant
- `GET /api/etudiants/{matricule}/emploi-du-temps` - Emploi du temps

## Securite

- Authentification JWT
- Tokens expires apres 30 minutes
- Codes OTP expires apres 15 minutes
- Validation des numeros camerounais
- CORS configure
- Protection Spring Security

## Licence

Projet academique - College Rattrapo

## Auteur

Developpe pour le College Rattrapo - Cameroun
