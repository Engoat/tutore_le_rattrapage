package cm.institutsaintjean.suiviacademique.dto;

import lombok.Data;

@Data
public class DemandeVerificationOtp {
    private String numeroTelephone;
    private String codeOtp;
}
