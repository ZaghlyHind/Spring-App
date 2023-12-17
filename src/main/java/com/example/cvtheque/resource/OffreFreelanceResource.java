package com.example.cvtheque.resource;

import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.OffreFreelance;
import com.example.cvtheque.service.OffreFreelanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offreFreelance")
public class OffreFreelanceResource {
    private final OffreFreelanceService offreFreelanceService;

    public OffreFreelanceResource(OffreFreelanceService offreFreelanceService) {
        this.offreFreelanceService = offreFreelanceService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<OffreFreelance>> getAllOffresFreelance () {
        List<OffreFreelance> offresFreelance = offreFreelanceService.findAllOffresFreelance();
        return new ResponseEntity<>(offresFreelance, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<OffreFreelance> getOffreFreelanceById (@PathVariable("idOffreFreelance") Long idOffreFreelance) {
        OffreFreelance offreFreelance = offreFreelanceService.findOffreFreelanceById(idOffreFreelance);
        return new ResponseEntity<>(offreFreelance, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OffreFreelance> addOffreFreelance(@RequestBody OffreFreelance offreFreelance) {
        OffreFreelance newOffreFreelance = offreFreelanceService.addOffreFreelance(offreFreelance);
        return new ResponseEntity<>(newOffreFreelance, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OffreFreelance> updateOffreFreelance(@RequestBody OffreFreelance offreFreelance) {
        OffreFreelance updateOffreFreelance= offreFreelanceService.updateOffreFreelance(offreFreelance);
        return new ResponseEntity<>(updateOffreFreelance, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idOffreFreelance}")
    public ResponseEntity<?> deleteOffreFreelance(@PathVariable("idOffreFreelance") Long idOffreFreelance) {
        offreFreelanceService.deleteOffreFreelance(idOffreFreelance);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


