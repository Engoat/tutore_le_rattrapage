package cm.institutsaintjean.suiviacademique.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceNormalisationTelephone {

    public List<String> normaliserEtSeparer(String numerosTelephone) {
        if (numerosTelephone == null || numerosTelephone.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Separer par le slash
        String[] parties = numerosTelephone.split("/");
        
        List<String> numerosNormalises = new ArrayList<>();
        for (String partie : parties) {
            String numeroNormalise = normaliser(partie);
            if (!numeroNormalise.isEmpty()) {
                numerosNormalises.add(numeroNormalise);
            }
        }
        
        return numerosNormalises;
    }

    public String normaliser(String numeroTelephone) {
        if (numeroTelephone == null || numeroTelephone.trim().isEmpty()) {
            return "";
        }

        // Enlever tous les caracteres non numeriques sauf le +
        String nettoye = numeroTelephone.replaceAll("[\\s()\\-]", "");
        
        // Enlever le + au debut
        if (nettoye.startsWith("+")) {
            nettoye = nettoye.substring(1);
        }

        // Enlever le code pays 237 si present
        if (nettoye.startsWith("237")) {
            nettoye = nettoye.substring(3);
        }

        // Garder seulement les 9 chiffres du numero camerounais
        return nettoye.trim();
    }

    public boolean correspond(String numeroEntree, String numeroStocke) {
        String numeroEntreeNormalise = normaliser(numeroEntree);
        List<String> numerosStockesNormalises = normaliserEtSeparer(numeroStocke);

        for (String numero : numerosStockesNormalises) {
            if (numero.equals(numeroEntreeNormalise)) {
                return true;
            }
        }

        return false;
    }
}
