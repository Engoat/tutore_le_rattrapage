package cm.institutsaintjean.suiviacademique.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class ControleurDonnees {

    @Autowired
    private DataSource dataSource;

    @PostMapping("/init-data")
    public ResponseEntity<String> initialiserDonnees() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            // Insertion des classes
            stmt.execute("INSERT IGNORE INTO classe (id, libelle, filiere, niveau) VALUES " +
                    "('CL001', 'Terminale C', 'Scientifique', 'Terminale'), " +
                    "('CL002', 'Seconde A', 'Litteraire', 'Seconde'), " +
                    "('CL003', 'Premiere D', 'Scientifique', 'Premiere'), " +
                    "('CL004', 'Premiere S', 'Scientifique', 'Premiere'), " +
                    "('CL005', 'Terminale D', 'Scientifique', 'Terminale'), " +
                    "('CL006', 'Seconde C', 'Scientifique', 'Seconde')");

            // Insertion des étudiants - Famille NGUEMA (693583680)
            stmt.execute("INSERT IGNORE INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES " +
                    "('ETU001', 'NGUEMA', 'Alice', '2008-03-15', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677445566', 'CL003'), " +
                    "('ETU002', 'NGUEMA', 'David', '2007-11-20', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677556677', 'CL001'), " +
                    "('ETU003', 'NGUEMA', 'Sarah', '2009-07-10', 'NGUEMA Paul', 'MBALLA Sylvie', '693583680', '677445566', 'CL002')");

            // Autres familles
            stmt.execute("INSERT IGNORE INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES " +
                    "('ETU004', 'MBARGA', 'Jean', '2008-05-15', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL001'), " +
                    "('ETU005', 'MBARGA', 'Sophie', '2010-08-20', 'MBARGA Paul', 'NKOLO Marie', '693147445', '675234567', 'CL002'), " +
                    "('ETU006', 'FOTSO', 'Emmanuel', '2009-03-10', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL004'), " +
                    "('ETU007', 'FOTSO', 'Grace', '2008-12-05', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL005'), " +
                    "('ETU008', 'FOTSO', 'Michel', '2010-09-18', 'FOTSO Pierre', 'KAMGA Jeanne', '677123456', '678234567', 'CL006')");

            stmt.execute("INSERT IGNORE INTO etudiant (matricule, nom, prenom, date_naissance, nom_pere, nom_mere, telephone_pere, telephone_mere, classe_id) VALUES " +
                    "('ETU009', 'ESSOMBA', 'Carole', '2007-06-22', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL005'), " +
                    "('ETU010', 'ESSOMBA', 'Patrick', '2008-04-14', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL003'), " +
                    "('ETU011', 'ESSOMBA', 'Nadine', '2009-11-30', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL004'), " +
                    "('ETU012', 'ESSOMBA', 'Kevin', '2010-02-17', 'ESSOMBA Jean', 'ATEBA Rose', '676789012', '679345678', 'CL006')");

            // Insertion des inscriptions principales
            stmt.execute("INSERT IGNORE INTO inscription (id, code_ue, matricule_etudiant, annee_academique, semestre) VALUES " +
                    "('INS001', 'MAT101', 'ETU001', '2025-2026', 'Semestre 1'), " +
                    "('INS002', 'PHY101', 'ETU001', '2025-2026', 'Semestre 1'), " +
                    "('INS006', 'MAT101', 'ETU002', '2025-2026', 'Semestre 1'), " +
                    "('INS007', 'PHY101', 'ETU002', '2025-2026', 'Semestre 1'), " +
                    "('INS011', 'MAT101', 'ETU003', '2025-2026', 'Semestre 1'), " +
                    "('INS015', 'MAT101', 'ETU004', '2025-2026', 'Semestre 1'), " +
                    "('INS018', 'FRA101', 'ETU005', '2025-2026', 'Semestre 1')");

            // Insertion des notes
            stmt.execute("INSERT IGNORE INTO note (id, inscription_id, type_evaluation, valeur_note, libelle_matiere) VALUES " +
                    "('NOT001', 'INS001', 'CC', 15.5, 'Mathematiques'), " +
                    "('NOT002', 'INS001', 'SN', 14.0, 'Mathematiques'), " +
                    "('NOT003', 'INS002', 'CC', 16.0, 'Physique'), " +
                    "('NOT010', 'INS006', 'CC', 17.0, 'Mathematiques'), " +
                    "('NOT011', 'INS006', 'SN', 16.5, 'Mathematiques'), " +
                    "('NOT012', 'INS007', 'CC', 18.0, 'Physique'), " +
                    "('NOT019', 'INS011', 'CC', 12.5, 'Mathematiques'), " +
                    "('NOT025', 'INS015', 'CC', 15.5, 'Mathematiques'), " +
                    "('NOT030', 'INS018', 'CC', 14.5, 'Francais')");

            return ResponseEntity.ok("✅ Données initialisées avec succès ! " +
                    "7 familles ajoutées avec 19 enfants. " +
                    "Ton numéro 693583680 a 3 enfants : Alice, David et Sarah NGUEMA.");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("❌ Erreur : " + e.getMessage());
        }
    }
}