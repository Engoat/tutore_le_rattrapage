package cm.institutsaintjean.suiviacademique.dto;

import lombok.Data;

@Data
public class ReponseEnvoiOtp {
    private String message;
    private boolean otpEnvoye;

    public ReponseEnvoiOtp(String message, boolean otpEnvoye) {
        this.message = message;
        this.otpEnvoye = otpEnvoye;
    }
}
