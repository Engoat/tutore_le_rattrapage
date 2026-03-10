package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "etudiant")
@Data
public class Etudiant {

    @Id
    @Column(name = "matricule")
    private String matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "nom_pere")
    private String nomPere;

    @Column(name = "nom_mere")
    private String nomMere;

    @Column(name = "telephone_pere")
    private String telephonePere;

    @Column(name = "telephone_mere")
    private String telephoneMere;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> inscriptions;
}
