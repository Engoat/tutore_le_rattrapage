package cm.institutsaintjean.suiviacademique.services;

import cm.institutsaintjean.suiviacademique.entites.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceAuthentification {

    @Autowired
    private ServiceNormalisationTelephone serviceNormalisationTelephone;

    @Autowired
    private ServiceOtp serviceOtp;

    @Autowired
    private ServiceSms serviceSms;

    @Autowired
    private ServiceJwt serviceJwt;

    @Autowired
    private ServiceEtudiant serviceEtudiant;

    public void envoyerOtp(String numeroTelephone) {
        // Vérifier si le numéro existe dans la base de données
        List<Etudiant> etudiants = serviceEtudiant.trouverEtudiantsParTelephoneParent(numeroTelephone);
        
        if (etudiants.isEmpty()) {
            throw new RuntimeException("Aucun compte trouvé avec ce numéro");
        }

        // Normaliser le numero pour le stockage OTP
        String numeroNormalise = serviceNormalisationTelephone.normaliser(numeroTelephone);

        // Generer le code OTP
        String codeOtp = serviceOtp.genererOtp();

        // Stocker le code avec une validite de 15 minutes
        serviceOtp.stockerOtp(numeroNormalise, codeOtp, 15);

        // Envoyer le SMS
        String message = "Votre code de verification est: " + codeOtp + ". Valide pendant 15 minutes.";
        serviceSms.envoyerSms(numeroTelephone, message);
    }

    public String verifierOtp(String numeroTelephone, String codeOtp) {
        // Normaliser le numero
        String numeroNormalise = serviceNormalisationTelephone.normaliser(numeroTelephone);

        // Valider le code OTP
        boolean estValide = serviceOtp.validerOtp(numeroNormalise, codeOtp);

        if (!estValide) {
            throw new RuntimeException("Code OTP invalide ou expire");
        }

        // Supprimer le code OTP utilise
        serviceOtp.invaliderOtp(numeroNormalise);

        // Generer et retourner le token JWT
        return serviceJwt.genererToken(numeroNormalise);
    }
}
