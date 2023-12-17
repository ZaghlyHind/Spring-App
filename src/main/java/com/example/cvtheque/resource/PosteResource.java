package com.example.cvtheque.resource;

import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.service.PosteService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poste")
public class PosteResource {
    private final PosteService posteService;

    public PosteResource(PosteService posteService) {
        this.posteService = posteService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Poste>> getAllPostes () {
        List<Poste> postes = posteService.findAllPostes();
        return new ResponseEntity<>(postes, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Poste> getOffreById (@PathVariable("id") Long id) {
        Poste poste = posteService.findPosteById(id);
        return new ResponseEntity<>(poste, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Poste> addPoste(@RequestBody Poste poste) {
        Poste newPoste = posteService.addPoste(poste);
        return new ResponseEntity<>(newPoste, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Poste> updatePoste(@RequestBody Poste poste) {
        Poste updatePoste= posteService.updatePoste(poste);
        return new ResponseEntity<>(updatePoste, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePoste(@PathVariable("id") Long id) {
        posteService.deletePoste(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

