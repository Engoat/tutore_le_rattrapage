package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "classe")
@Data
public class Classe {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "filiere")
    private String filiere;

    @Column(name = "niveau")
    private String niveau;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @OneToOne(mappedBy = "classe")
    private EmploiDuTemps emploiDuTemps;
}
