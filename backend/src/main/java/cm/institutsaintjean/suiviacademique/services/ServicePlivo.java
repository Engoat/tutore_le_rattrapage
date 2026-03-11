package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Base64;

@Service
public class ServicePlivo {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser Plivo API avec identifiants de test
            String jsonBody = String.format(
                "{\"src\":\"SuiviAcademique\",\"dst\":\"%s\",\"text\":\"%s\"}", 
                numeroFormate, 
                message.replace("\"", "\\\"")
            );
            
            String auth = Base64.getEncoder().encodeToString("demo:demo".getBytes());
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.plivo.com/v1/Account/demo/Message/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + auth)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== PLIVO SMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("===============================");
            
            return response.statusCode() == 201 || response.statusCode() == 202;
            
        } catch (Exception e) {
            System.err.println("Erreur Plivo: " + e.getMessage());
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