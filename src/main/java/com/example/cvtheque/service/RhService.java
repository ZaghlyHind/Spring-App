package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.RH;
import com.example.cvtheque.repo.RhRepo;
import com.example.cvtheque.util.RhSessionUtil;
import com.example.cvtheque.util.SessionUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RhService {
    private final RhRepo rhRepo;
    private final RhSessionUtil sessionUtil;

    @Autowired
    public RhService(RhRepo rhRepo, RhSessionUtil sessionUtil) {
        this.rhRepo = rhRepo;
        this.sessionUtil = sessionUtil;
    }
    @Transactional
    public RH updateRh(RH rh) {
        return rhRepo.save(rh);
    }
    @Transactional
    public RH addRh(RH rh) {
        return rhRepo.save(rh);
    }

    @Transactional
    public RH findRhById(int id) {
        return rhRepo.findRhById(id)
                .orElseThrow(() -> new UserNotFoundException("RH by id " + id + " was not found"));
    }
    @Transactional
    public RH getProfileRH(int rhId) {
        return rhRepo.findRhById(rhId)
                .orElseThrow(() -> new UserNotFoundException("User by id " + rhId + " was not found"));

    }
    @Transactional
    public RH login(String email, String password) {
        Optional<RH> rhOptional = rhRepo.findRhByEmail(email);

        if (rhOptional.isPresent()) {
            RH rh = rhOptional.get();

            // Stockez l'ID du RH dans la session avant de vérifier le mot de passe
            sessionUtil.setLoggedInRhId(rh.getId());

            if (rh.getPassword().equals(password)) {
                return rh; // Connexion réussie
            }
        }

        // Si l'utilisateur n'est pas trouvé ou que le mot de passe ne correspond pas, vous pouvez générer une exception
        throw new UserNotFoundException("Invalid email or password");
    }
}
