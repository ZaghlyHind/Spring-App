package com.example.cvtheque.resource;

import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.service.OffreCDIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offreCDI")
public class OffreCDIResource {
    private final OffreCDIService offreCDIService;

    public OffreCDIResource(OffreCDIService offreCDIService) {
        this.offreCDIService = offreCDIService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<OffreCDI>> getAllOffresCDI () {
        List<OffreCDI> offresCDI = offreCDIService.findAllOffresCDI();
        return new ResponseEntity<>(offresCDI, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<OffreCDI> getOffreCDIById (@PathVariable("idOffreCDI") Long idOffreCDI) {
        OffreCDI offreCDI = offreCDIService.findOffreCDIById(idOffreCDI);
        return new ResponseEntity<>(offreCDI, HttpStatus.OK);
    }

    @PostMapping("/add/{idCandidature}")
    public ResponseEntity<OffreCDI> addOffreCDI(@RequestBody OffreCDI offreCDI) {
        OffreCDI newOffreCDI = offreCDIService.addOffreCdi(offreCDI);
        return new ResponseEntity<>(newOffreCDI, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OffreCDI> updateOffreCDI(@RequestBody OffreCDI offreCDI) {
        OffreCDI updateOffreCDI= offreCDIService.updateOffreCDI(offreCDI);
        return new ResponseEntity<>(updateOffreCDI, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idOffreCDI}")
    public ResponseEntity<?> deleteOffreCDI(@PathVariable("idOffreCDI") Long idOffreCDI) {
        offreCDIService.deleteOffreCDI(idOffreCDI);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
