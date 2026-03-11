package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceSmsGlobal {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser SMSGlobal API (gratuit avec crédit de test)
            String requestBody = String.format(
                "action=sendsms&user=test&password=test&to=%s&text=%s", 
                numeroFormate.replace("+", ""), 
                message
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.smsglobal.com/http-api.php"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== SMS GLOBAL ENVOYE ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("=========================");
            
            return response.statusCode() == 200 && !response.body().contains("ERROR");
            
        } catch (Exception e) {
            System.err.println("Erreur SMSGlobal: " + e.getMessage());
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