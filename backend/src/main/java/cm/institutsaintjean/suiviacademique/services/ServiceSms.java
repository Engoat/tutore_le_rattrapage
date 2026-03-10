package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;

@Service
public class ServiceSms {

    public void envoyerSms(String numeroTelephone, String message) {
        // Version mock pour le developpement
        // En production, on utiliserait Twilio ou un autre service
        System.out.println("=== ENVOI SMS ===");
        System.out.println("Destinataire: " + numeroTelephone);
        System.out.println("Message: " + message);
        System.out.println("=================");
    }
}
