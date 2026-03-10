# Requirements Document

## Introduction

La Plateforme de Suivi Académique Parents-Établissement est une application web sécurisée développée pour l'Institut Universitaire Saint Jean Ingénieur au Cameroun. Elle permet aux parents d'élèves de consulter en temps réel les informations académiques de leurs enfants sans nécessiter de mot de passe traditionnel. Le système utilise une authentification par numéro de téléphone et code OTP envoyé par SMS, particulièrement adaptée au contexte camerounais où l'accès aux téléphones mobiles est plus répandu que les adresses email fiables.

L'application offre un accès aux notes (générées en PDF via JasperReports), aux emplois du temps de classe, et vise à améliorer la communication entre l'établissement scolaire et les familles. Un parent peut avoir plusieurs enfants inscrits dans l'établissement et accéder à leurs informations via un seul numéro de téléphone.

## Glossary

- **Parent System**: Le système d'authentification et d'accès pour les parents d'élèves via numéro de téléphone
- **Authentication Module**: Le module gérant l'authentification par numéro de téléphone et code OTP sans mot de passe traditionnel
- **Student Portal**: L'interface permettant de visualiser la liste des enfants et leurs informations académiques
- **Grade Report Generator**: Le composant générant les bulletins de notes au format PDF via JasperReports
- **Schedule Viewer**: Le composant permettant de télécharger les emplois du temps de classe en PDF
- **OTP (One-Time Password)**: Code de validation à usage unique de 15 minutes envoyé par SMS
- **Session Manager**: Le gestionnaire de sessions utilisateur basé sur le numéro de téléphone validé
- **Academic Data Repository**: Le référentiel contenant toutes les données académiques (étudiants, notes, classes, emplois du temps)
- **SMS Gateway**: Le service d'envoi de SMS pour les codes OTP (ex: Twilio, BulkSMS, opérateurs locaux)
- **PDF Generator**: Le moteur JasperReports obligatoire pour la génération de documents PDF de notes
- **Phone Number Normalizer**: Le composant normalisant les numéros de téléphone multivalués (format: "670000000/690000000/(237)68000000")
- **Student Enrollment**: L'inscription d'un étudiant représentée par le code UE, matricule, année académique et semestre
- **Evaluation Types**: Les types d'évaluation - CC (Contrôle Continu), SN (Synthèse Nationale), TP (Travaux Pratiques), RAT (Rattrapage)

## Requirements

### Requirement 1

**User Story:** En tant que parent, je veux m'authentifier avec mon numéro de téléphone et un code SMS sans utiliser de mot de passe, afin d'accéder de manière sécurisée aux informations académiques de mes enfants même si je n'ai pas d'adresse email

#### Acceptance Criteria

1. WHEN a Parent System receives a phone number input, THE Authentication Module SHALL normalize the phone number format and send an OTP code via SMS Gateway to the provided phone number
2. THE Authentication Module SHALL generate a unique OTP code with a validity period of exactly 15 minutes from the moment of SMS transmission
3. WHEN a Parent System receives an OTP code input within the 15-minute validity period, THE Authentication Module SHALL validate the code against the normalized phone number and grant access
4. IF an OTP code is submitted after the 15-minute validity period, THEN THE Authentication Module SHALL reject the authentication attempt and display an expiration message requiring a new OTP request
5. WHEN authentication is successful, THE Session Manager SHALL create a session linked to the validated phone number with a minimum duration of 30 minutes
6. THE Phone Number Normalizer SHALL handle multivalued phone numbers in the format "670000000/690000000/(237)68000000" and match any of the provided numbers
7. THE Phone Number Normalizer SHALL accept numeric, alphabetic, and alphanumeric phone number values

### Requirement 2

**User Story:** En tant que parent avec plusieurs enfants dans l'établissement, je veux voir la liste de tous mes enfants associés à mon numéro de téléphone, afin de sélectionner celui dont je souhaite consulter les informations

#### Acceptance Criteria

1. WHEN a parent successfully authenticates, THE Student Portal SHALL retrieve and display all students whose father's phone number(s) or mother's phone number(s) match the authenticated phone number
2. THE Student Portal SHALL display for each student the first name, last name, current class label, academic track (filière), and level (niveau)
3. THE Student Portal SHALL provide two distinct action buttons labeled "Notes" and "Emploi du temps" for each student in the list
4. WHILE a valid session exists, THE Student Portal SHALL maintain access to the student list without requiring re-authentication
5. IF the session expires or becomes invalid, THEN THE Parent System SHALL redirect the user to the authentication page
6. THE Student Portal SHALL support parents with multiple children by displaying all associated students in a single list view

### Requirement 3

**User Story:** En tant que parent, je veux télécharger un bulletin de notes PDF complet de mon enfant généré par JasperReports, afin d'avoir une vue détaillée et imprimable de tous ses résultats académiques par type d'évaluation

#### Acceptance Criteria

1. WHEN a parent clicks the "Notes" action button for a specific student, THE Grade Report Generator SHALL retrieve all grade records associated with that student's enrollment across all subjects
2. THE Grade Report Generator SHALL include in the PDF report for each grade: the evaluation type (CC, SN, TP, or RAT), the grade value, the subject name (libellé matière), the course code (code UE), the academic year (année académique), and the semester (semestre)
3. THE Grade Report Generator SHALL use JasperReports engine exclusively to generate the PDF document with proper formatting and layout
4. THE Parent System SHALL initiate an automatic download of the generated PDF document to the parent's browser
5. THE Grade Report Generator SHALL complete the PDF generation and download initiation within 10 seconds of the request
6. THE Grade Report Generator SHALL organize grades by subject and evaluation type for clear readability

### Requirement 4

**User Story:** En tant que parent, je veux télécharger l'emploi du temps PDF de la classe de mon enfant, afin de connaître son planning hebdomadaire de cours

#### Acceptance Criteria

1. WHEN a parent clicks the "Emploi du temps" action button for a specific student, THE Schedule Viewer SHALL identify the student's current class (libellé, filière, niveau)
2. THE Schedule Viewer SHALL retrieve the schedule PDF URL associated with the identified class from the Academic Data Repository
3. THE Parent System SHALL initiate an automatic download of the PDF document from the stored URL to the parent's browser
4. THE Schedule Viewer SHALL complete the download initiation within 5 seconds of the request
5. IF no schedule PDF URL is available for the class, THEN THE Parent System SHALL display a user-friendly message indicating that the schedule is not yet available
6. THE Academic Data Repository SHALL store for each class schedule a label (libellé), the associated class reference, and the PDF file URL

### Requirement 5

**User Story:** En tant qu'administrateur système, je veux que les données des étudiants et leurs relations familiales soient correctement structurées avec support des numéros multiples, afin de garantir l'intégrité des informations et permettre l'authentification des parents

#### Acceptance Criteria

1. THE Academic Data Repository SHALL store for each student a unique registration number (matricule), last name (nom), first name (prénom), date of birth (date de naissance), father's name (nom du père), mother's name (nom de la mère), father's phone number(s) (téléphone du père), mother's phone number(s) (téléphone de la mère), and current class reference
2. THE Academic Data Repository SHALL support multiple phone numbers for each parent stored in slash-separated format (example: "670000000/690000000/(237)68000000")
3. THE Academic Data Repository SHALL accept and store phone number values that are numeric, alphabetic, or alphanumeric without validation constraints on format
4. THE Academic Data Repository SHALL store for each class a designation label (libellé), academic track (filière), and level (niveau)
5. THE Academic Data Repository SHALL store for each grade record the evaluation type (CC, SN, TP, or RAT), grade value (valeur de la note), subject name (libellé de la matière), and student enrollment reference
6. THE Academic Data Repository SHALL store for each student enrollment the course code (code UE), student registration number (matricule étudiant), academic year (année académique), and semester (semestre)
7. THE Academic Data Repository SHALL maintain referential integrity between students, classes, enrollments, and grades

### Requirement 6

**User Story:** En tant que chef de projet, je veux que l'application soit développée avec Angular 20+ pour le frontend et Spring Boot pour le backend, afin de respecter les contraintes techniques imposées et assurer la maintenabilité du projet

#### Acceptance Criteria

1. THE Parent System frontend SHALL be implemented using Angular framework version 20 or higher with TypeScript
2. THE Parent System backend SHALL be implemented using Spring Boot framework version 3.x or higher with Java
3. THE Parent System SHALL expose RESTful API endpoints following REST principles for all communication between Angular frontend and Spring Boot backend
4. THE Authentication Module SHALL integrate with an SMS Gateway service (such as Twilio, BulkSMS, or local Cameroonian operators like Orange/MTN) for OTP delivery
5. THE PDF Generator SHALL use JasperReports library exclusively (not pdfmake, jsPDF, or other alternatives) for grade report document generation
6. THE Parent System SHALL use a relational database management system (MySQL, PostgreSQL, or equivalent) for the Academic Data Repository
7. THE Parent System SHALL be deployable and ready for presentation by March 12, 2026

### Requirement 7

**User Story:** En tant que parent, je veux que mes données personnelles et les informations académiques de mes enfants soient protégées par des mécanismes de sécurité robustes, afin de garantir la confidentialité et empêcher tout accès non autorisé

#### Acceptance Criteria

1. THE Authentication Module SHALL require valid OTP verification before granting access to any academic data or student information
2. THE Session Manager SHALL automatically invalidate sessions after a period of inactivity not exceeding 30 minutes
3. THE Parent System SHALL implement authorization controls to restrict data access so that parents can only view information for students whose father's or mother's phone number matches the authenticated phone number
4. THE Parent System SHALL use HTTPS protocol exclusively for all client-server communications to encrypt data in transit
5. THE Academic Data Repository SHALL implement appropriate security measures to protect sensitive student and parent data at rest
6. THE Parent System SHALL log all authentication attempts and data access for security audit purposes
7. THE Parent System SHALL prevent SQL injection, XSS, and CSRF attacks through input validation and security best practices

### Requirement 8

**User Story:** En tant qu'administrateur système, je veux que le système gère correctement l'association entre numéros de téléphone et étudiants multiples, afin de supporter les familles avec plusieurs enfants et les numéros partagés

#### Acceptance Criteria

1. THE Parent System SHALL support a single phone number being associated with multiple students (siblings in the same establishment)
2. THE Phone Number Normalizer SHALL remove formatting characters (slashes, spaces, parentheses, country codes) before matching phone numbers in the database
3. WHEN a phone number matches multiple entries in the father's or mother's phone fields, THE Student Portal SHALL display all associated students in the parent's dashboard
4. THE Academic Data Repository SHALL treat each slash-separated phone number as an independent valid authentication credential
5. THE Authentication Module SHALL successfully authenticate a parent if any of their registered phone numbers (father's or mother's) matches the input phone number after normalization

## Open Questions and Assumptions

The following points require clarification from the project stakeholders (Arthur PESSA / Emmanuel MOUPOJOU) before design phase:

1. **SMS Gateway Service**: Which SMS provider should be used (Twilio, BulkSMS, Orange Cameroon, MTN Cameroon)? Is there an existing account/API key, or should we implement a mock service for development?

2. **Database Source**: Is there an existing database with student, grade, and class data? If yes, what DBMS (MySQL, PostgreSQL, etc.) and can we access the schema? Or should we create a new database from scratch?

3. **JasperReports Templates**: Are there existing JasperReports templates (.jrxml files) for grade reports, or should we design new ones? What should be the exact layout and branding?

4. **Schedule PDF Storage**: Are class schedule PDFs already uploaded and stored somewhere (file server, cloud storage, local directory)? Or do we need to implement a PDF upload feature for administrators?

5. **Notifications Feature**: The project mentions "Recevoir des notifications importantes (réunions des parents, etc.)". Is this a required feature to implement (browser push notifications, additional SMS, email, in-app alerts), or is it just contextual information without implementation requirement for this project?

6. **Phone Number Format**: Should the system support international formats, or only Cameroonian numbers? Should we validate phone number formats or accept any alphanumeric string as specified?

7. **Session Management**: Should sessions be stored server-side (Redis, database) or client-side (JWT tokens)? What happens if a parent logs in from multiple devices simultaneously?

**Assumptions for Design Phase** (if questions remain unanswered):
- We will implement a mock SMS service for development that logs OTP codes to console
- We will create a new PostgreSQL database with sample data
- We will design basic JasperReports templates for grade reports
- Schedule PDFs will be stored in a local file system directory with URLs in the database
- Notifications feature is out of scope for this initial version
- Phone numbers will be normalized by removing non-numeric characters except country codes
- Sessions will use JWT tokens stored in browser localStorage with server-side validation
