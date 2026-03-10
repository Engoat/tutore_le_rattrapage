package cm.institutsaintjean.suiviacademique.repositories;

import cm.institutsaintjean.suiviacademique.entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {
    
    List<Etudiant> findByTelephonePereContainingOrTelephoneMereContaining(
        String telephonePere, 
        String telephoneMere
    );
}
