package cm.institutsaintjean.suiviacademique.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EtudiantDto {
    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private ClasseDto classe;
}
