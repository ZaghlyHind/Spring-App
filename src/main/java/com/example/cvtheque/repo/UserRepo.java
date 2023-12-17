package com.example.cvtheque.repo;

import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}