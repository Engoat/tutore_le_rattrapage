package cm.institutsaintjean.suiviacademique.services;

import cm.institutsaintjean.suiviacademique.entites.Etudiant;
import cm.institutsaintjean.suiviacademique.entites.Inscription;
import cm.institutsaintjean.suiviacademique.entites.Note;
import cm.institutsaintjean.suiviacademique.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceEtudiant {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ServiceNormalisationTelephone serviceNormalisationTelephone;

    public List<Etudiant> trouverEtudiantsParTelephoneParent(String numeroTelephone) {
        // Recuperer tous les etudiants
        List<Etudiant> tousLesEtudiants = etudiantRepository.findAll();

        // Filtrer les etudiants dont le parent a ce numero
        List<Etudiant> etudiantsTrouves = new ArrayList<>();
        
        for (Etudiant etudiant : tousLesEtudiants) {
            boolean correspondPere = serviceNormalisationTelephone.correspond(
                numeroTelephone, 
                etudiant.getTelephonePere()
            );
            
            boolean correspondMere = serviceNormalisationTelephone.correspond(
                numeroTelephone, 
                etudiant.getTelephoneMere()
            );

            if (correspondPere || correspondMere) {
                etudiantsTrouves.add(etudiant);
            }
        }

        return etudiantsTrouves;
    }

    public Etudiant trouverParMatricule(String matricule) {
        return etudiantRepository.findById(matricule)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouve"));
    }

    public boolean estAutoriseAVoirEtudiant(String numeroTelephone, Etudiant etudiant) {
        boolean correspondPere = serviceNormalisationTelephone.correspond(
            numeroTelephone, 
            etudiant.getTelephonePere()
        );
        
        boolean correspondMere = serviceNormalisationTelephone.correspond(
            numeroTelephone, 
            etudiant.getTelephoneMere()
        );

        return correspondPere || correspondMere;
    }

    public Map<String, Object> obtenirNotesParSemestre(String matricule) {
        Etudiant etudiant = trouverParMatricule(matricule);
        Map<String, Object> resultat = new HashMap<>();
        
        // Semestre 1
        List<Map<String, Object>> notesSemestre1 = new ArrayList<>();
        double totalSemestre1 = 0;
        int countSemestre1 = 0;
        
        for (Inscription inscription : etudiant.getInscriptions()) {
            if ("Semestre 1".equals(inscription.getSemestre())) {
                double totalMatiere = 0;
                int countMatiere = 0;
                
                for (Note note : inscription.getNotes()) {
                    totalMatiere += note.getValeurNote().doubleValue();
                    countMatiere++;
                }
                
                if (countMatiere > 0) {
                    double moyenneMatiere = totalMatiere / countMatiere;
                    Map<String, Object> matiereInfo = new HashMap<>();
                    matiereInfo.put("matiere", inscription.getNotes().get(0).getLibelleMatiere());
                    matiereInfo.put("moyenne", Math.round(moyenneMatiere * 100.0) / 100.0);
                    
                    List<Map<String, Object>> details = new ArrayList<>();
                    for (Note note : inscription.getNotes()) {
                        Map<String, Object> noteDetail = new HashMap<>();
                        noteDetail.put("type", note.getTypeEvaluation());
                        noteDetail.put("note", note.getValeurNote().doubleValue());
                        details.add(noteDetail);
                    }
                    matiereInfo.put("notes", details);
                    
                    notesSemestre1.add(matiereInfo);
                    totalSemestre1 += moyenneMatiere;
                    countSemestre1++;
                }
            }
        }
        
        resultat.put("semestre1", notesSemestre1);
        resultat.put("moyenneSemestre1", countSemestre1 > 0 ? Math.round((totalSemestre1 / countSemestre1) * 100.0) / 100.0 : 0);
        
        // Semestre 2 (vide pour l'instant)
        resultat.put("semestre2", new ArrayList<>());
        resultat.put("moyenneSemestre2", null);
        
        return resultat;
    }

    public Map<String, Object> obtenirEmploiDuTemps(String matricule) {
        Etudiant etudiant = trouverParMatricule(matricule);
        Map<String, Object> resultat = new HashMap<>();
        
        if (etudiant.getClasse() != null && etudiant.getClasse().getEmploiDuTemps() != null) {
            resultat.put("libelle", etudiant.getClasse().getEmploiDuTemps().getLibelle());
            resultat.put("pdfUrl", etudiant.getClasse().getEmploiDuTemps().getPdfUrl());
            resultat.put("classe", etudiant.getClasse().getLibelle());
        } else {
            resultat.put("message", "Aucun emploi du temps disponible");
        }
        
        return resultat;
    }
}
