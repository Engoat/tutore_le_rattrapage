package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceFreeSms {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser FreeSMS.org - service VRAIMENT gratuit
            String requestBody = String.format(
                "phoneNumber=%s&message=%s", 
                numeroFormate, 
                java.net.URLEncoder.encode(message, "UTF-8")
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.freesms.org/api/send"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("User-Agent", "SuiviAcademique/1.0")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== SMS FREESMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("=================================");
            
            // FreeSMS retourne 200 même en cas d'erreur, vérifier le contenu
            return response.statusCode() == 200 && 
                   !response.body().toLowerCase().contains("error") &&
                   !response.body().toLowerCase().contains("failed");
            
        } catch (Exception e) {
            System.err.println("Erreur FreeSMS: " + e.getMessage());
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