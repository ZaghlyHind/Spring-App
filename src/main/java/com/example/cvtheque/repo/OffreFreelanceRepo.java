package com.example.cvtheque.repo;

import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.OffreFreelance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OffreFreelanceRepo extends JpaRepository<OffreFreelance, Long> {
    void deleteOffreFreelanceById(Long idOffreFreelance);

    Optional<OffreFreelance> findOffreFreelanceById(Long idOffreFreelance);
}

