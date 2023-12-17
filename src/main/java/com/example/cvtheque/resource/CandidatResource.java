package com.example.cvtheque.resource;

import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.InscriptionRequest;
import com.example.cvtheque.model.LoginRequest;
import com.example.cvtheque.model.User;
import com.example.cvtheque.repo.CandidatRepo;
import com.example.cvtheque.service.CandidatService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidat")
public class CandidatResource {
    private final CandidatService candidatService;
    private CandidatRepo candidatRepo;
    public CandidatResource(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Candidat>> getAllCandidats () {
        List<Candidat> candidats = candidatService.findAllCandidats();

        for (Candidat candidat : candidats) {
            // Récupérez le nom du fichier du CV
            String cvNom = candidat.getCvNom();

            // Vous pouvez maintenant inclure cvNom dans les informations du candidat
            candidat.setCvNom(cvNom);
        }

        return new ResponseEntity<>(candidats, HttpStatus.OK);
    }
    @GetMapping("/profile/{candidatId}")
    public ResponseEntity<Candidat> getProfileCandidat(@PathVariable int candidatId) {
        Candidat candidat = candidatService.getProfileCandidat(candidatId);
        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }


    @GetMapping("/{id}/cv")
    public ResponseEntity<byte[]> downloadCv(@PathVariable int id) {
        Candidat candidat = candidatService.findCandidatById(id);

        if (candidat != null && candidat.getCv() != null) {
            // Vous pouvez personnaliser le type de contenu ici en fonction du type de fichier CV que vous stockez
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF); // Par exemple, si c'est un fichier PDF

            // Vous pouvez également personnaliser le nom du fichier de téléchargement ici
            headers.setContentDispositionFormData("attachment", candidat.getCvNom());

            return new ResponseEntity<>(candidat.getCv(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Candidat> getCandidatById (@PathVariable("id") int id) {
        Candidat candidat = candidatService.findCandidatById(id);
        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidat> addCandidat(
                                                @RequestPart("cv") MultipartFile cv,
                                                @RequestParam("nom") String nom,
                                                @RequestParam("prenom") String prenom,
                                                @RequestParam("email") String email,
                                                @RequestParam("numCin") String numCin,
                                                @RequestParam("tel") String tel,
                                                @RequestParam("domaine") String domaine,
                                                @RequestParam("poste") String poste,
                                                @RequestParam("password") String password

                                                ) throws IOException{
        byte[] cvData = cv.getBytes();
        String cvNom = cv.getOriginalFilename();
        Candidat candidat = new Candidat();
        candidat.setNom(nom);
        candidat.setPrenom(prenom);
        candidat.setEmail(email);
        candidat.setNumCin(numCin);
        candidat.setTel(tel);
        candidat.setDomaine(domaine);
        candidat.setPoste(poste);
        // Assignez d'autres champs du formulaire

        candidat.setCv(cvData); // Assignez les données de l'image à l'attribut "image"
        candidat.setCvNom(cvNom);
        candidat.setPassword(password);
        Candidat savedCandidat = candidatService.addCandidat(candidat);

        return new ResponseEntity<>(savedCandidat, HttpStatus.OK);


    }

   /* @PostMapping("/inscription")
    public ResponseEntity<String> inscrireCandidat(@RequestPart("cv") MultipartFile cv,
                                                   @RequestParam("email") String email,
                                                   @RequestParam("password") String password,
                                                   @RequestParam("nom") String nom,
                                                   @RequestParam("prenom") String prenom,
                                                   @RequestParam("numCin") String numCin,
                                                   @RequestParam("domaine") String domaine,
                                                   @RequestParam("poste") String poste,
                                                   @RequestParam("tel") String tel) {
        User user = candidatService.inscrireCandidat(email, password, nom, prenom, numCin, poste, domaine, tel, cv);
        return ResponseEntity.ok("Candidat inscrit avec succès. ID de l'utilisateur : " + user.getId());
    }*/




    @PutMapping("/update")
    public ResponseEntity<Candidat> updateCandidat(@RequestBody Candidat candidat) {
        Candidat updateCandidat = candidatService.updateCandidat(candidat);
        return new ResponseEntity<>(updateCandidat, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCandidat(@PathVariable("id") int id) {
        candidatService.deleteCandidat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Candidat> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Candidat candidat = candidatService.login(email, password);

        return new ResponseEntity<>(candidat, HttpStatus.OK);
    }
}
