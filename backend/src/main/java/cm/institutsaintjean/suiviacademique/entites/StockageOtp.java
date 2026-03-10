package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "stockage_otp")
@Data
public class StockageOtp {

    @Id
    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "code_otp")
    private String codeOtp;

    @Column(name = "cree_le")
    private LocalDateTime creeLe;

    @Column(name = "expire_le")
    private LocalDateTime expireLe;
}
