package cm.institutsaintjean.suiviacademique.services;

import cm.institutsaintjean.suiviacademique.entites.StockageOtp;
import cm.institutsaintjean.suiviacademique.repositories.StockageOtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class ServiceOtp {

    @Autowired
    private StockageOtpRepository stockageOtpRepository;

    public String genererOtp() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    public void stockerOtp(String numeroTelephone, String codeOtp, int dureeValiditeMinutes) {
        StockageOtp stockage = new StockageOtp();
        stockage.setNumeroTelephone(numeroTelephone);
        stockage.setCodeOtp(codeOtp);
        stockage.setCreeLe(LocalDateTime.now());
        stockage.setExpireLe(LocalDateTime.now().plusMinutes(dureeValiditeMinutes));
        
        stockageOtpRepository.save(stockage);
    }

    public boolean validerOtp(String numeroTelephone, String codeOtp) {
        Optional<StockageOtp> stockageOpt = stockageOtpRepository.findByNumeroTelephone(numeroTelephone);
        
        if (!stockageOpt.isPresent()) {
            return false;
        }

        StockageOtp stockage = stockageOpt.get();
        
        // Verifier si le code est expire
        if (LocalDateTime.now().isAfter(stockage.getExpireLe())) {
            return false;
        }

        // Verifier si le code correspond
        if (!stockage.getCodeOtp().equals(codeOtp)) {
            return false;
        }

        return true;
    }

    public void invaliderOtp(String numeroTelephone) {
        stockageOtpRepository.deleteById(numeroTelephone);
    }
}
