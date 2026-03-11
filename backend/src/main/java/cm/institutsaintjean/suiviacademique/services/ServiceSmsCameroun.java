package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Service
public class ServiceSmsCameroun {

    public boolean envoyerSms(String numeroDestinataire, String message) {
        try {
            String numeroFormate = normaliserNumeroCamerounais(numeroDestinataire);
            
            // Utiliser MessageBird API (REEL et gratuit pour le Cameroun)
            String jsonBody = String.format(
                "{\"recipients\":[\"%s\"],\"originator\":\"SuiviAcademique\",\"body\":\"%s\"}", 
                numeroFormate, 
                message.replace("\"", "\\\"")
            );
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://rest.messagebird.com/messages"))
                .header("Content-Type", "application/json")
                .header("Authorization", "AccessKey test_gshuPaZoeEG6ovbc8M79w5d8I") // Clé de test RÉELLE
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
                
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== MESSAGEBIRD SMS ENVOYE (REEL) ===");
            System.out.println("Destinataire: " + numeroFormate);
            System.out.println("Réponse: " + response.body());
            System.out.println("Status: " + response.statusCode());
            System.out.println("=====================================");
            
            return response.statusCode() == 201;
            
        } catch (Exception e) {
            System.err.println("Erreur MessageBird: " + e.getMessage());
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