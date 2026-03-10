package cm.institutsaintjean.suiviacademique.repositories;

import cm.institutsaintjean.suiviacademique.entites.EmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, String> {
    
    Optional<EmploiDuTemps> findByClasseId(String classeId);
}
