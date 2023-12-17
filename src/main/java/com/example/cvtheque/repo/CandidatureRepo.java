package com.example.cvtheque.repo;

import com.example.cvtheque.model.Candidature;
import com.example.cvtheque.model.OffreCDI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatureRepo extends JpaRepository<Candidature, Integer> {

    Optional<Candidature> findCandidatureById(int id);
    List<Candidature> findAllByCandidatId(int idCandidat);
    List<Candidature> findAllByEtat(String etat);

}
