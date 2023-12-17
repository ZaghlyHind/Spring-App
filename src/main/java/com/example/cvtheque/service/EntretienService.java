package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.Entretien;
import com.example.cvtheque.repo.CandidatureRepo;
import com.example.cvtheque.repo.EntretienRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EntretienService {
    private final EntretienRepo entretienRepo;
    private final CandidatureRepo candidatureRepo;

    private final CandidatureService candidatureService;

    public EntretienService(EntretienRepo entretienRepo, CandidatureRepo candidatureRepo, CandidatureService candidatureService) {
        this.entretienRepo = entretienRepo;
        this.candidatureRepo = candidatureRepo;
        this.candidatureService = candidatureService;
    }
    @Transactional
    public Entretien addEntretienWithCandidature(Entretien entretien) {

        return entretienRepo.save(entretien);
    }


    @Transactional
    public List<Entretien> findAllEntretiens() {
        return entretienRepo.findAll();
    }
    @Transactional
    public Entretien findEntretienById(int id) {
        return entretienRepo.findEntretienById(id)
                .orElseThrow(() -> new UserNotFoundException("Entretien by id " + id + " was not found"));
    }
    @Transactional
    public Entretien updateEntretien(Entretien entretien) {
        return entretienRepo.save(entretien);
    }
    @Transactional
    public List<Entretien> findEntretiensByCandidatId(int idCandidat) {
        return entretienRepo.findByCandidature_Candidat_Id(idCandidat);
    }


}
