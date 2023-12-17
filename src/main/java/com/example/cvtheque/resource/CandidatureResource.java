package com.example.cvtheque.resource;

import com.example.cvtheque.model.Candidature;
import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.Entretien;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.service.CandidatureService;
import com.example.cvtheque.service.CandidatService;
import com.example.cvtheque.service.EntretienService;
import com.example.cvtheque.service.PosteService;
import com.example.cvtheque.util.SessionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/candidature")
public class CandidatureResource {
    private final CandidatureService candidatureService;
    private final EntretienService entretienService;
    private final CandidatService candidatService;
    private final PosteService posteService;
    private final SessionUtil sessionUtil;

    public CandidatureResource(CandidatureService candidatureService, EntretienService entretienService, SessionUtil sessionUtil, CandidatService candidatService, PosteService posteService) {
        this.candidatureService = candidatureService;
        this.entretienService = entretienService;
        this.candidatService = candidatService;
        this.posteService = posteService;
        this.sessionUtil = sessionUtil;

    }
    @GetMapping("/accepted")
    public ResponseEntity<List<Candidature>> getAcceptedCandidatures() {
        List<Candidature> acceptedCandidatures = candidatureService.findAcceptedCandidatures();
        return new ResponseEntity<>(acceptedCandidatures, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidature>> getAllCandidatures() {
        List<Candidature> candidatures = candidatureService.findAllCandidatures();
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Candidature> getCandidatureById(@PathVariable("id") int id) {
        Candidature candidature = candidatureService.findCandidatureById(id);
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }
    @GetMapping("/all/{idCandidat}")
    public ResponseEntity<List<Candidature>> getCandidaturesByCandidatId(@PathVariable("idCandidat") int idCandidat) {
        List<Candidature> candidatures = candidatureService.getCandidaturesByCandidatId(idCandidat);

        if (candidatures != null && !candidatures.isEmpty()) {
            return new ResponseEntity<>(candidatures, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Renvoie un code HTTP 404 si aucune candidature n'est trouvée
        }
    }

    /* @PostMapping("/add")
    public ResponseEntity<Candidature> addCandidature(@RequestBody Candidature candidature) {
        Candidature newCandidature = candidatureService.addCandidature(candidature);
        return new ResponseEntity<>(newCandidature, HttpStatus.CREATED);
    }

    @PostMapping("/addByCandidatAndPoste/{candidatId}/{posteId}")
    public ResponseEntity<Candidature> addCandidatureByCandidatAndPoste(
            @PathVariable("candidatId") int candidatId,
            @PathVariable("posteId") Long posteId
    ) {
        Candidat candidat = candidatService.findCandidatById(candidatId);
        Poste poste = posteService.findPosteById(posteId);

        if (candidat != null && poste != null) {
            Candidature nouvelleCandidature = new Candidature(candidat, poste);
            candidatureService.addCandidature(nouvelleCandidature);
            return new ResponseEntity<>(nouvelleCandidature, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
   @PostMapping("/postuler/{idOffre}/{idCandidat}")
   public ResponseEntity<Candidature> postuler(
           @RequestBody Candidature candidature,
           @PathVariable("idOffre") Long idOffre,
           @PathVariable("idCandidat") int idCandidat
   ) {
       // Validez les données de la candidature (assurez-vous que les champs obligatoires sont remplis)

       // Récupérez l'offre correspondante par son ID
       Poste poste = posteService.findPosteById(idOffre);

       // Récupérez le candidat correspondant par son ID
       Candidat candidat = candidatService.findCandidatById(idCandidat);

       if (poste != null && candidat != null) {
           // Associez l'offre à la candidature
           candidature.setPoste(poste);
           // Associez le candidat à la candidature
           candidature.setCandidat(candidat);

           // Initialisez la date de candidature et l'état
           candidature.setDatePostulation(new Date());
           candidature.setEtat("En cours");

           // Enregistrez la candidature dans la base de données
           Candidature nouvelleCandidature = candidatureService.addCandidature(candidature);

           // Retournez la nouvelle candidature avec un code HTTP 201 (Created)
           return ResponseEntity.created(URI.create("/candidature/" + nouvelleCandidature.getId()))
                   .body(nouvelleCandidature);
       } else {
           // L'offre ou le candidat n'existe pas, retournez une réponse d'erreur avec le code HTTP 404 (Not Found)
           return ResponseEntity.notFound().build();
       }
   }

    @PutMapping("/valider/{id}")
    public ResponseEntity<?> validateCandidature(@PathVariable("id") int candidatureId) {
        Candidature candidature = candidatureService.findCandidatureById(candidatureId);
        if (candidature != null) {
            candidature.setEtat("accepté");
            candidatureService.updateCandidature(candidature);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/refuser/{id}")
    public ResponseEntity<?> refuseCandidature(@PathVariable("id") int candidatureId) {
        Candidature candidature = candidatureService.findCandidatureById(candidatureId);
        if (candidature != null) {
            candidature.setEtat("refusé");
            candidatureService.updateCandidature(candidature);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
