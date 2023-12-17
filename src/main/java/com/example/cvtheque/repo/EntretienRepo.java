package com.example.cvtheque.repo;

import com.example.cvtheque.model.Candidature;
import com.example.cvtheque.model.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntretienRepo extends JpaRepository<Entretien, Integer> {
    Optional<Entretien> findEntretienById(int id);
    List<Entretien> findByCandidature_Candidat_Id(int idCandidat);

}
