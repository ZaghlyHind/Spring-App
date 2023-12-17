package com.example.cvtheque.resource;

import com.example.cvtheque.model.Candidature;
import com.example.cvtheque.model.Entretien;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.service.CandidatureService;
import com.example.cvtheque.service.EntretienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/entretien")
public class EntretienResource {
    private final EntretienService entretienService;
    private final CandidatureService candidatureService;

    public EntretienResource(EntretienService entretienService, CandidatureService candidatureService) {
        this.entretienService = entretienService;
        this.candidatureService = candidatureService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Entretien>> getAllEntretiens() {
        List<Entretien> entretiens = entretienService.findAllEntretiens();
        return new ResponseEntity<>(entretiens, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Entretien> getEntretienById(@PathVariable("id") int id) {
        Entretien entretien = entretienService.findEntretienById(id);
        return new ResponseEntity<>(entretien, HttpStatus.OK);
    }
    @PostMapping("/add/{idCandidature}")
    public ResponseEntity<Entretien> addEntretien(@PathVariable("idCandidature") int idCandidature, @RequestBody Entretien entretien) {
        Candidature candidature =candidatureService.findCandidatureById(idCandidature);
        if (candidature != null) {
            // Associez l'offre à la candidature
            entretien.setCandidature(candidature);
            // Associez le candidat à la candidature

            // Initialisez la date de candidature et l'état
            entretien.setRetourClient("non  déterminé");

            // Enregistrez la candidature dans la base de données
            Entretien nouvelleEntretien = entretienService.addEntretienWithCandidature(entretien);

            // Retournez la nouvelle candidature avec un code HTTP 201 (Created)
            return ResponseEntity.created(URI.create("/candidature/" + nouvelleEntretien.getId()))
                    .body(nouvelleEntretien);
        } else {
            // L'offre ou le candidat n'existe pas, retournez une réponse d'erreur avec le code HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/byCandidat/{idCandidat}")
    public ResponseEntity<List<Entretien>> getEntretiensByCandidatId(@PathVariable("idCandidat") int idCandidat) {
        List<Entretien> entretiens = entretienService.findEntretiensByCandidatId(idCandidat);
        return new ResponseEntity<>(entretiens, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Entretien> updateEntretien(@RequestBody Entretien entretien) {
        Entretien updateEntretien= entretienService.updateEntretien(entretien);
        return new ResponseEntity<>(updateEntretien, HttpStatus.OK);
    }
}
