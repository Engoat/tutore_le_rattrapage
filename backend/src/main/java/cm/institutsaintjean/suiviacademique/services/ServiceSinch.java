package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Base64;

@Service
public class ServiceSinch {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser Sinch API (REEL et gratuit)
            String jsonBody = String.format(
                "{\"from\":\"SuiviAcademique\",\"to\":[\"%s\"],\"body\":\"%s\"}", 
                numeroFormate, 
                message.replace("\"", "\\\"")
            );
            
            // Utiliser les identifiants de test Sinch RÉELS
            String auth = Base64.getEncoder().encodeToString("application\\demo:demo".getBytes());
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sms.api.sinch.com/xms/v1/demo/batches"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + auth)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== SINCH SMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("===============================");
            
            return response.statusCode() == 201;
            
        } catch (Exception e) {
            System.err.println("Erreur Sinch: " + e.getMessage());
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