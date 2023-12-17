package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.Poste;
import com.example.cvtheque.repo.OffreCdiRepo;
import com.example.cvtheque.repo.OffreFreelanceRepo;
import com.example.cvtheque.repo.PosteRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PosteService {
    private final PosteRepo posteRepo;
    private final OffreCdiRepo offreCdiRepo;
    private final OffreFreelanceRepo offreFreelanceRepo;
    public PosteService(PosteRepo posteRepo, OffreCdiRepo offreCdiRepo, OffreFreelanceRepo offreFreelanceRepo) {
        this.posteRepo = posteRepo;
        this.offreCdiRepo = offreCdiRepo;
        this.offreFreelanceRepo = offreFreelanceRepo;
    }
    @Transactional
    public Poste addPoste(Poste poste) {
        return posteRepo.save(poste);
    }

    @Transactional
    public List<Poste> findAllPostes() {
        return posteRepo.findAll();
    }

    @Transactional
    public Poste updatePoste(Poste poste) {
        return posteRepo.save(poste);
    }

    @Transactional
    public Poste findPosteById(Long id) {
        return posteRepo.findPosteById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    @Transactional
    public void deletePoste(Long id) {
        posteRepo.deletePosteById(id);
    }

}

