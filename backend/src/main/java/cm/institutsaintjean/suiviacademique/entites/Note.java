package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "note")
@Data
public class Note {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "inscription_id")
    private Inscription inscription;

    @Column(name = "type_evaluation")
    private String typeEvaluation;

    @Column(name = "valeur_note")
    private BigDecimal valeurNote;

    @Column(name = "libelle_matiere")
    private String libelleMatiere;
}
