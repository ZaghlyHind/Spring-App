package com.example.cvtheque.repo;
import com.example.cvtheque.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PosteRepo extends JpaRepository<Poste, Long> {
    void deletePosteById(Long id);

    Optional<Poste> findPosteById(Long id);
}
