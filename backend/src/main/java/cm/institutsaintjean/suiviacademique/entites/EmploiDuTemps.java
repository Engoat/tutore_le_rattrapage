package cm.institutsaintjean.suiviacademique.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emploi_du_temps")
@Data
public class EmploiDuTemps {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "libelle")
    private String libelle;

    @OneToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @Column(name = "pdf_url")
    private String pdfUrl;
}
