# Rattrapo Tutore - Plateforme de Suivi Academique

Plateforme web de suivi academique pour le College Rattrapo permettant aux parents de consulter les informations scolaires de leurs enfants via authentification OTP par SMS.

## 🚀 Fonctionnalites

- **Authentification securisee par OTP (SMS)** avec 7 services SMS réels
- **Consultation des informations des enfants**
- **Visualisation des notes par semestre** avec moyennes
- **Acces aux emplois du temps des classes**
- **Interface responsive et moderne**
- **Support des numeros camerounais** (tous formats)

## 📱 Services SMS Intégrés

L'application utilise plusieurs services SMS en cascade pour garantir la livraison :

1. **MessageBird** - API gratuite avec crédit de test
2. **Sinch** - API SMS gratuite
3. **Infobip** - Crédit de test gratuit
4. **Vonage** - API gratuite
5. **Plivo** - Crédit de test
6. **TextBelt** - 1 SMS gratuit par jour
7. **Twilio** - Service principal (nécessite configuration)

## ⚙️ Configuration

### Configuration Twilio (Recommandé)

1. Créez un compte sur [Twilio](https://www.twilio.com)
2. Obtenez vos identifiants dans la console Twilio
3. Copiez le fichier d'exemple :
```bash
cp backend/src/main/resources/application.properties.example backend/src/main/resources/application.properties
```
4. Modifiez `application.properties` avec vos identifiants :
```properties
twilio.account.sid=VOTRE_ACCOUNT_SID
twilio.auth.token=VOTRE_AUTH_TOKEN
twilio.phone.number=VOTRE_NUMERO_TWILIO
```

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
CREATE DATABASE suivi_academique_clean CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Configurer les identifiants dans `backend/src/main/resources/application.properties`

### Lancement

1. Demarrer le backend:
```bash
cd backend
./mvnw spring-boot:run
```

2. Ouvrir le frontend:
```
Ouvrir frontend/index.html dans un navigateur
```

## 📋 Test de l'Application

1. **Ouvrez** `frontend/index.html`
2. **Cliquez** sur "Se connecter"
3. **Entrez** votre numéro de téléphone (format : 693583680)
4. **Cliquez** sur "Envoyer OTP"
5. **Recevez** le code SMS sur votre téléphone
6. **Entrez** le code pour vous connecter

## Utilisation

### Connexion
1. Entrer un numero de telephone camerounais
2. Recevoir le code OTP par SMS réel
3. Valider le code
4. Consulter les informations des enfants

### Numeros de test

| Numero | Famille | Enfants |
|--------|---------|---------|
| 693583680 | FAMILLE_TEST | Jean Dupont, Marie Martin |
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
│   │   │   │       └── services/        # 7 services SMS réels
│   │   │   └── resources/
│   │   │       ├── application.properties.example
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
- **Secrets Twilio sécurisés** (non commitées)

## 🔧 Services SMS

L'application teste automatiquement 7 services SMS différents jusqu'à ce qu'un réussisse :

1. **MessageBird** - Service fiable avec API gratuite
2. **Sinch** - API SMS gratuite
3. **Infobip** - Crédit de test gratuit
4. **Vonage** - API gratuite
5. **Plivo** - Crédit de test
6. **TextBelt** - 1 SMS gratuit par jour
7. **Twilio** - Service principal (configuration requise)

## Licence

Projet academique - College Rattrapo

## Auteur

Developpe pour le College Rattrapo - Cameroun

---

**Développé avec ❤️ pour l'Institut Saint-Jean**
