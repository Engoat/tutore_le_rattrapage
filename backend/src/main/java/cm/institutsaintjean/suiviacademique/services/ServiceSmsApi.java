package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceSmsApi {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser SMSApi.com - service fiable avec crédit gratuit
            String requestBody = String.format(
                "to=%s&message=%s&from=SuiviAcademique&format=json", 
                numeroFormate.replace("+", ""), 
                java.net.URLEncoder.encode(message, "UTF-8")
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.smsapi.com/sms.do"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Bearer demo_token") // Token de démo
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== SMSAPI ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("============================");
            
            return response.statusCode() == 200;
            
        } catch (Exception e) {
            System.err.println("Erreur SMSApi: " + e.getMessage());
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