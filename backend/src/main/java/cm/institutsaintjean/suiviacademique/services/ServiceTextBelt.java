package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceTextBelt {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser TextBelt API (gratuit, 1 SMS/jour)
            String requestBody = String.format(
                "phone=%s&message=%s&key=textbelt", 
                numeroFormate, 
                message
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://textbelt.com/text"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== SMS TEXTBELT ENVOYE (GRATUIT) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("=====================================");
            
            // Vérifier si la réponse contient "success":true
            boolean success = response.statusCode() == 200 && 
                             response.body().contains("\"success\":true");
            
            if (!success) {
                System.out.println("TextBelt a échoué, essai Twilio...");
            }
            
            return success;
            
        } catch (Exception e) {
            System.err.println("Erreur TextBelt: " + e.getMessage());
            return false;
        }
    }
    
    private String normaliserNumeroCamerounais(String numero) {
        String clean = numero.replaceAll("[\\s+\\-()]", "");
        if (clean.startsWith("237")) {
            clean = clean.substring(3);
        }
        return "+237" + clean;
    }
    
    public boolean estDisponible() {
        return true; // TextBelt est toujours disponible
    }
}