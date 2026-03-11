package cm.institutsaintjean.suiviacademique.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceTwilio {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    private boolean initialized = false;

    private void initializeTwilio() {
        if (!initialized && accountSid != null && authToken != null) {
            Twilio.init(accountSid, authToken);
            initialized = true;
        }
    }

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            initializeTwilio();
            
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser le numéro Twilio configuré
            String fromNumber = fromPhoneNumber;
            
            Message twilioMessage = Message.creator(
                new PhoneNumber(numeroFormate), // To (destinataire)
                new PhoneNumber(fromNumber), // From (numéro Twilio)
                message // Body (message)
            ).create();
            
            System.out.println("=== SMS TWILIO ENVOYE (REEL) ===");
            System.out.println("SID: " + twilioMessage.getSid());
            System.out.println("De: " + fromNumber);
            System.out.println("Vers: " + numeroFormate);
            System.out.println("Statut: " + twilioMessage.getStatus());
            System.out.println("Prix: " + twilioMessage.getPrice());
            System.out.println("================================");
            
            return true;
            
        } catch (Exception e) {
            System.err.println("Erreur envoi SMS Twilio: " + e.getMessage());
            e.printStackTrace();
            
            // Fallback en mode simulé si l'API échoue
            System.out.println("=== SMS TWILIO (FALLBACK SIMULE) ===");
            System.out.println("Destinataire: " + normaliserNumeroCamerounais(numeroDestinataire));
            System.out.println("Message: " + message);
            System.out.println("Erreur: " + e.getMessage());
            System.out.println("===================================");
            
            return false;
        }
    }

    private String normaliserNumeroCamerounais(String numero) {
        // Enlever espaces, +, parenthèses, tirets
        String clean = numero.replaceAll("[\\s+\\-()]", "");
        
        // Si commence par 237, enlever
        if (clean.startsWith("237")) {
            clean = clean.substring(3);
        }
        
        // Ajouter le code pays +237
        return "+237" + clean;
    }

    public boolean estDisponible() {
        return accountSid != null && authToken != null && !accountSid.isEmpty() && !authToken.isEmpty();
    }
}