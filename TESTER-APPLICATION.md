## 🧪 TESTER L'APPLICATION - Plateforme Suivi Académique

### ✅ Configuration Twilio SMS
- **Account SID**: Configuré ✓
- **Auth Token**: Configuré ✓
- **Service**: Prêt pour l'envoi de vrais SMS ✓

### 🚀 Lancement de l'application

#### Backend (Spring Boot)
```bash
cd backend
.\lancer.bat
```

**Note**: Si Maven n'est pas installé, le script te donnera les instructions.

#### Frontend 
Ouvre simplement `frontend/index.html` dans ton navigateur.

### 📱 Test de l'envoi SMS avec Twilio

#### 1. Test d'authentification avec OTP
1. Va sur `http://localhost:8080` (frontend)
2. Clique sur "Se connecter"
3. Entre le numéro `693583680` (ou un autre numéro de test)
4. Clique sur "Envoyer OTP"

**Résultat attendu**: 
- Tu devrais recevoir un vrai SMS avec le code OTP sur le 693583680
- Dans les logs du backend, tu verras : `=== SMS TWILIO ENVOYE ===`
- Après connexion, tu verras 2 enfants : Alice et David NGUEMA

#### 2. Vérification des logs
Dans la console du backend, cherche :
```
=== SMS TWILIO ENVOYE ===
SID: SM...
Destinataire: +237677123456
Statut: queued/sent/delivered
=========================
```

#### 3. Test avec différents numéros
Teste avec ces formats :
- `677123456` → sera converti en `+237677123456`
- `+237 677 123 456` → sera normalisé
- `237677123456` → sera converti en `+237677123456`

### 🔧 Dépannage

#### Si les SMS ne partent pas :
1. Vérifie les logs pour voir les erreurs Twilio
2. Assure-toi que ton compte Twilio a du crédit
3. Vérifie que le numéro de destination est valide

#### Si l'application ne démarre pas :
1. Assure-toi que MySQL est démarré
2. Vérifie que le port 8080 est libre
3. Regarde les logs d'erreur dans la console

### 📊 Comptes de test disponibles

**Parents** (numéros pour l'authentification):
- `693583680` - Paul NGUEMA (2 enfants: Alice et David)
- `693147445` - MBARGA (2 enfants: Jean et Sophie) 
- `676789012` - ESSOMBA (4 enfants)
- `671234567` - NKOMO (3 enfants)

**Étudiants** (après connexion parent):
- Alice NGUEMA - Première S (bonnes notes)
- David NGUEMA - Terminale C (très bonnes notes)
- Jean MBARGA - Terminale C
- Sophie MBARGA - Seconde A

### 🎯 Fonctionnalités à tester

1. **Authentification OTP** ✓ (avec vrais SMS Twilio)
2. **Consultation notes** 
3. **Emploi du temps**
4. **Notifications parents** (SMS automatiques)

---

**🔥 Twilio est maintenant configuré et prêt !**
L'application enverra de vrais SMS pour l'authentification et les notifications.