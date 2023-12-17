package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.Candidature;
import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.repo.CandidatureRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CandidatureService {
    private final CandidatureRepo candidatureRepo;

    public CandidatureService(CandidatureRepo candidatureRepo) {
        this.candidatureRepo = candidatureRepo;
    }
    @Transactional
    public Candidature addCandidature(Candidature candidature) {
        return candidatureRepo.save(candidature);
    }

    @Transactional
    public List<Candidature> findAllCandidatures() {
        return candidatureRepo.findAll();
    }

    @Transactional
    public List<Candidature> getCandidaturesByCandidatId(int candidatId) {
        return candidatureRepo.findAllByCandidatId(candidatId);
    }
    @Transactional
    public List<Candidature> findAcceptedCandidatures() {
        return candidatureRepo.findAllByEtat("accepté");
    }
    @Transactional
    public Candidature findCandidatureById(int id) {
        return candidatureRepo.findCandidatureById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    @Transactional
    public Candidature updateCandidature(Candidature candidature) {
        return candidatureRepo.save(candidature);
    }
}
