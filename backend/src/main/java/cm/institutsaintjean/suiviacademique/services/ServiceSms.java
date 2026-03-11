package cm.institutsaintjean.suiviacademique.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSms {

    @Autowired
    private ServiceSmsCameroun serviceSmsCameroun; // MessageBird REEL
    
    @Autowired
    private ServiceSinch serviceSinch; // Sinch REEL
    
    @Autowired
    private ServiceInfobip serviceInfobip; // Infobip REEL
    
    @Autowired
    private ServiceVonage serviceVonage; // Vonage REEL
    
    @Autowired
    private ServicePlivo servicePlivo; // Plivo REEL
    
    @Autowired
    private ServiceTextBelt serviceTextBelt; // TextBelt REEL (1 SMS/jour)
    
    @Autowired
    private ServiceTwilio serviceTwilio; // Twilio REEL (limite atteinte)

    public void envoyerSms(String numeroTelephone, String message) {
        // UNIQUEMENT des services SMS RÉELS - AUCUNE SIMULATION
        
        // 1. MessageBird (REEL - gratuit avec crédit de test)
        if (serviceSmsCameroun.estDisponible()) {
            boolean success = serviceSmsCameroun.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via MessageBird !");
                return;
            }
            System.out.println("MessageBird a échoué, essai Sinch...");
        }
        
        // 2. Sinch (REEL - API gratuite)
        if (serviceSinch.estDisponible()) {
            boolean success = serviceSinch.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via Sinch !");
                return;
            }
            System.out.println("Sinch a échoué, essai Infobip...");
        }
        
        // 3. Infobip (REEL - crédit de test gratuit)
        if (serviceInfobip.estDisponible()) {
            boolean success = serviceInfobip.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via Infobip !");
                return;
            }
            System.out.println("Infobip a échoué, essai Vonage...");
        }
        
        // 4. Vonage (REEL - API gratuite)
        if (serviceVonage.estDisponible()) {
            boolean success = serviceVonage.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via Vonage !");
                return;
            }
            System.out.println("Vonage a échoué, essai Plivo...");
        }
        
        // 5. Plivo (REEL - crédit de test)
        if (servicePlivo.estDisponible()) {
            boolean success = servicePlivo.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via Plivo !");
                return;
            }
            System.out.println("Plivo a échoué, essai TextBelt...");
        }
        
        // 6. TextBelt (REEL - 1 SMS gratuit par jour)
        if (serviceTextBelt.estDisponible()) {
            boolean success = serviceTextBelt.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via TextBelt !");
                return;
            }
            System.out.println("TextBelt a échoué, essai Twilio...");
        }
        
        // 7. Twilio (REEL - mais limite atteinte)
        if (serviceTwilio.estDisponible()) {
            boolean success = serviceTwilio.envoyerSms(numeroTelephone, message);
            if (success) {
                System.out.println("✅ SMS REEL ENVOYE via Twilio !");
                return;
            }
            System.out.println("Twilio a échoué (limite atteinte)");
        }
        
        // ÉCHEC TOTAL - TOUS LES SERVICES RÉELS ONT ÉCHOUÉ
        System.out.println("❌ ÉCHEC CRITIQUE : TOUS LES 7 SERVICES SMS RÉELS ONT ÉCHOUÉ");
        System.out.println("Destinataire: " + numeroTelephone);
        System.out.println("Message: " + message);
        System.out.println("AUCUNE SIMULATION - UNIQUEMENT DES SERVICES RÉELS TESTÉS");
    }
}
