package com.example.cvtheque.repo;

import com.example.cvtheque.model.OffreCDI;
import com.example.cvtheque.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OffreCdiRepo extends JpaRepository<OffreCDI, Long> {
    void deleteOffreCDIById(Long idOffreCDI);

    Optional<OffreCDI> findOffreCDIById(Long idOffreCDI);
}