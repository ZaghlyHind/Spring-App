package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.OffreFreelance;
import com.example.cvtheque.repo.OffreFreelanceRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OffreFreelanceService {
    private final OffreFreelanceRepo offreFreelanceRepo;

    public OffreFreelanceService(OffreFreelanceRepo offreFreelanceRepo) {
        this.offreFreelanceRepo = offreFreelanceRepo;
    }

    @Transactional
    public OffreFreelance addOffreFreelance(OffreFreelance offreFreelance) {
        return offreFreelanceRepo.save(offreFreelance);
    }

    @Transactional
    public List<OffreFreelance> findAllOffresFreelance() {
        return offreFreelanceRepo.findAll();
    }

    @Transactional
    public OffreFreelance updateOffreFreelance(OffreFreelance offreFreelance) {
        return offreFreelanceRepo.save(offreFreelance);
    }

    @Transactional
    public OffreFreelance findOffreFreelanceById(Long idOffreFreelance) {
        return offreFreelanceRepo.findOffreFreelanceById(idOffreFreelance)
                .orElseThrow(() -> new UserNotFoundException("User by id " + idOffreFreelance + " was not found"));
    }

    @Transactional
    public void deleteOffreFreelance(Long idOffreFreelance) {
        offreFreelanceRepo.deleteOffreFreelanceById(idOffreFreelance);
    }
}



