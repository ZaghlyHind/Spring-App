package com.example.cvtheque.repo;

import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.RH;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RhRepo extends JpaRepository<RH, Integer> {
    void deleteRhById(int id);

    Optional<RH> findRhById(int id);
    Optional<RH> findRhByEmail(String email);
  //  Optional<RH> findByUser_Id(Long userId);

}
