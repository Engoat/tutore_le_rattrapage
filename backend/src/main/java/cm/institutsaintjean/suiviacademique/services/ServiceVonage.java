package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceVonage {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser Vonage API avec clé de test
            String requestBody = String.format(
                "from=SuiviAcademique&to=%s&text=%s&api_key=demo&api_secret=demo", 
                numeroFormate.replace("+", ""), 
                java.net.URLEncoder.encode(message, "UTF-8")
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://rest.nexmo.com/sms/json"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== VONAGE SMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("================================");
            
            return response.statusCode() == 200 && 
                   response.body().contains("\"status\":\"0\"");
            
        } catch (Exception e) {
            System.err.println("Erreur Vonage: " + e.getMessage());
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