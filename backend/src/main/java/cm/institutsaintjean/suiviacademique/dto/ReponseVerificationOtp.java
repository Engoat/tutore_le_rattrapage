package cm.institutsaintjean.suiviacademique.dto;

import lombok.Data;

@Data
public class ReponseVerificationOtp {
    private String token;
    private long expireDans;

    public ReponseVerificationOtp(String token, long expireDans) {
        this.token = token;
        this.expireDans = expireDans;
    }
}
