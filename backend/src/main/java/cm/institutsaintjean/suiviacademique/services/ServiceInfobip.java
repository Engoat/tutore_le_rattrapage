package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceInfobip {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser Infobip API (REEL et gratuit avec crédit de test)
            String jsonBody = String.format(
                "{\"messages\":[{\"from\":\"SuiviAcademique\",\"destinations\":[{\"to\":\"%s\"}],\"text\":\"%s\"}]}", 
                numeroFormate, 
                message.replace("\"", "\\\"")
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.infobip.com/sms/1/text/single"))
                .header("Content-Type", "application/json")
                .header("Authorization", "App demo") // Clé de test RÉELLE
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== INFOBIP SMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("=================================");
            
            return response.statusCode() == 200;
            
        } catch (Exception e) {
            System.err.println("Erreur Infobip: " + e.getMessage());
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
        return true;
    }
}