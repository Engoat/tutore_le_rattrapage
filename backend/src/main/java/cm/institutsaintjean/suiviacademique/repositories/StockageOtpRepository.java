package cm.institutsaintjean.suiviacademique.repositories;

import cm.institutsaintjean.suiviacademique.entites.StockageOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface StockageOtpRepository extends JpaRepository<StockageOtp, String> {
    
    Optional<StockageOtp> findByNumeroTelephone(String numeroTelephone);
    
    void deleteByExpireLeLessThan(LocalDateTime maintenant);
}
