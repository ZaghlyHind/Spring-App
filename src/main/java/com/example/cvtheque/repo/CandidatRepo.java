package com.example.cvtheque.repo;

import com.example.cvtheque.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepo extends JpaRepository<Candidat, Integer> {
    void deleteCandidatById(int id);

    Optional<Candidat> findCandidatById(int id);
    Optional<Candidat> findCandidatByEmail(String email);
   // Optional<Candidat> findByUser_Id(Long userId);
}
