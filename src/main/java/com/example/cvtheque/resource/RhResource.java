package com.example.cvtheque.resource;

import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.LoginRequest;
import com.example.cvtheque.model.RH;
import com.example.cvtheque.repo.RhRepo;
import com.example.cvtheque.service.RhService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rh")
public class RhResource {
    private final RhService rhService;

    public RhResource(RhService rhService) {
        this.rhService = rhService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RH> getRhById(@PathVariable("id") int id) {
        RH rh = rhService.findRhById(id);
        return new ResponseEntity<>(rh, HttpStatus.OK);
    }

    @GetMapping("/profile/{rhId}")
    public ResponseEntity<RH> getProfileRH(@PathVariable int rhId) {
        RH rh = rhService.getProfileRH(rhId);
        return new ResponseEntity<>(rh, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<RH> updateRh(@RequestBody RH rh) {
        RH updateRh = rhService.updateRh(rh);
        return new ResponseEntity<>(updateRh, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<RH> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        RH rh = rhService.login(email, password);

        return new ResponseEntity<>(rh, HttpStatus.OK);
    }
}
