package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "inscription")
@Data
public class Inscription {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "code_ue")
    private String codeUe;

    @ManyToOne
    @JoinColumn(name = "matricule_etudiant")
    private Etudiant etudiant;

    @Column(name = "annee_academique")
    private String anneeAcademique;

    @Column(name = "semestre")
    private String semestre;

    @OneToMany(mappedBy = "inscription")
    private List<Note> notes;
}
