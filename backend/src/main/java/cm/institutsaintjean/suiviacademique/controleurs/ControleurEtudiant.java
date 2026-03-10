package cm.institutsaintjean.suiviacademique.controleurs;

import cm.institutsaintjean.suiviacademique.dto.ClasseDto;
import cm.institutsaintjean.suiviacademique.dto.EtudiantDto;
import cm.institutsaintjean.suiviacademique.entites.Etudiant;
import cm.institutsaintjean.suiviacademique.services.ServiceEtudiant;
import cm.institutsaintjean.suiviacademique.services.ServiceJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "*")
public class ControleurEtudiant {

    @Autowired
    private ServiceEtudiant serviceEtudiant;

    @Autowired
    private ServiceJwt serviceJwt;

    @GetMapping("/mes-enfants")
    public ResponseEntity<List<EtudiantDto>> obtenirMesEnfants(
        @RequestHeader("Authorization") String authHeader
    ) {
        try {
            // Extraire le token
            String token = authHeader.replace("Bearer ", "");
            
            // Extraire le numero de telephone du token
            String numeroTelephone = serviceJwt.extraireNumeroTelephone(token);

            // Trouver les etudiants
            List<Etudiant> etudiants = serviceEtudiant.trouverEtudiantsParTelephoneParent(numeroTelephone);

            // Convertir en DTO
            List<EtudiantDto> etudiantsDto = new ArrayList<>();
            for (Etudiant etudiant : etudiants) {
                EtudiantDto dto = new EtudiantDto();
                dto.setMatricule(etudiant.getMatricule());
                dto.setNom(etudiant.getNom());
                dto.setPrenom(etudiant.getPrenom());
                dto.setDateNaissance(etudiant.getDateNaissance());

                if (etudiant.getClasse() != null) {
                    ClasseDto classeDto = new ClasseDto();
                    classeDto.setLibelle(etudiant.getClasse().getLibelle());
                    classeDto.setFiliere(etudiant.getClasse().getFiliere());
                    classeDto.setNiveau(etudiant.getClasse().getNiveau());
                    dto.setClasse(classeDto);
                }

                etudiantsDto.add(dto);
            }

            return ResponseEntity.ok(etudiantsDto);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{matricule}/notes")
    public ResponseEntity<?> obtenirNotes(
        @PathVariable String matricule,
        @RequestHeader("Authorization") String authHeader
    ) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String numeroTelephone = serviceJwt.extraireNumeroTelephone(token);

            Etudiant etudiant = serviceEtudiant.trouverParMatricule(matricule);
            
            if (!serviceEtudiant.estAutoriseAVoirEtudiant(numeroTelephone, etudiant)) {
                return ResponseEntity.status(403).build();
            }

            return ResponseEntity.ok(serviceEtudiant.obtenirNotesParSemestre(matricule));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/{matricule}/emploi-du-temps")
    public ResponseEntity<?> obtenirEmploiDuTemps(
        @PathVariable String matricule,
        @RequestHeader("Authorization") String authHeader
    ) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String numeroTelephone = serviceJwt.extraireNumeroTelephone(token);

            Etudiant etudiant = serviceEtudiant.trouverParMatricule(matricule);
            
            if (!serviceEtudiant.estAutoriseAVoirEtudiant(numeroTelephone, etudiant)) {
                return ResponseEntity.status(403).build();
            }

            return ResponseEntity.ok(serviceEtudiant.obtenirEmploiDuTemps(matricule));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
