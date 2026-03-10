package cm.institutsaintjean.suiviacademique.controleurs;

import cm.institutsaintjean.suiviacademique.dto.*;
import cm.institutsaintjean.suiviacademique.services.ServiceAuthentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class ControleurAuthentification {

    @Autowired
    private ServiceAuthentification serviceAuthentification;

    @PostMapping("/envoyer-otp")
    public ResponseEntity<ReponseEnvoiOtp> envoyerOtp(@RequestBody DemandeEnvoiOtp demande) {
        try {
            serviceAuthentification.envoyerOtp(demande.getNumeroTelephone());
            ReponseEnvoiOtp reponse = new ReponseEnvoiOtp("Code envoye par SMS", true);
            return ResponseEntity.ok(reponse);
        } catch (RuntimeException e) {
            // Si le numéro n'existe pas dans la base
            if (e.getMessage().contains("Aucun compte")) {
                ReponseEnvoiOtp reponse = new ReponseEnvoiOtp(e.getMessage(), false);
                return ResponseEntity.ok(reponse);
            }
            // Autres erreurs (SMS, etc.)
            ReponseEnvoiOtp reponse = new ReponseEnvoiOtp("Erreur lors de l'envoi du SMS", false);
            return ResponseEntity.status(503).body(reponse);
        }
    }

    @PostMapping("/verifier-otp")
    public ResponseEntity<?> verifierOtp(@RequestBody DemandeVerificationOtp demande) {
        try {
            String token = serviceAuthentification.verifierOtp(
                demande.getNumeroTelephone(), 
                demande.getCodeOtp()
            );
            
            ReponseVerificationOtp reponse = new ReponseVerificationOtp(token, 1800);
            return ResponseEntity.ok(reponse);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Code invalide ou expire");
        }
    }
}
