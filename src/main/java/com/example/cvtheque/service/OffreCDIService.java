package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.repo.OffreCdiRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OffreCDIService {
    private final OffreCdiRepo offreCdiRepo;

    public OffreCDIService(OffreCdiRepo offreCdiRepo) {
        this.offreCdiRepo = offreCdiRepo;
    }

    @Transactional
    public OffreCDI addOffreCdi(OffreCDI offreCDI) {
        return offreCdiRepo.save(offreCDI);
    }

    @Transactional
    public List<OffreCDI> findAllOffresCDI() {
        return offreCdiRepo.findAll();
    }

    @Transactional
    public OffreCDI updateOffreCDI(OffreCDI offreCDI) {
        return offreCdiRepo.save(offreCDI);
    }

    @Transactional
    public OffreCDI findOffreCDIById(Long idOffreCDI) {
        return offreCdiRepo.findOffreCDIById(idOffreCDI)
                .orElseThrow(() -> new UserNotFoundException("User by id " + idOffreCDI + " was not found"));
    }

    @Transactional
    public void deleteOffreCDI(Long idOffreCDI) {
        offreCdiRepo.deleteOffreCDIById(idOffreCDI);
    }
}


