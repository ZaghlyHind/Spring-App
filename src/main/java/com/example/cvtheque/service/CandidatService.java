package com.example.cvtheque.service;

import com.example.cvtheque.exception.UserNotFoundException;
import com.example.cvtheque.model.Candidat;
import com.example.cvtheque.model.User;
import com.example.cvtheque.repo.CandidatRepo;
import com.example.cvtheque.repo.UserRepo;
import com.example.cvtheque.util.SessionUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {
    private final CandidatRepo candidatRepo;
    private final UserRepo userRepository;
    private final SessionUtil sessionUtil;

    @Autowired
    public CandidatService(CandidatRepo candidatRepo, UserRepo userRepository, SessionUtil sessionUtil) {
        this.candidatRepo = candidatRepo;
        this.userRepository = userRepository;
        this.sessionUtil = sessionUtil;
    }

    @Transactional
    public Candidat addCandidat(Candidat candidat) {
        return candidatRepo.save(candidat);
    }
  /*  @Transactional
    public User inscrireCandidat(String email, String password, String nom, String prenom, String numCin, String domaine, String poste, String tel, MultipartFile cv) {
        // Créez un nouvel utilisateur
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Assurez-vous de hacher le mot de passe
        user.setTypeUser("candidat");
        // Enregistrez l'utilisateur dans la base de données
        user = userRepository.save(user);

        // Créez un candidat associé à cet utilisateur
        byte[] cvData;
        String cvNom;

        try {
            cvData = cv.getBytes();
            cvNom = cv.getOriginalFilename();
        } catch (IOException e) {
            // Gérez l'exception, par exemple, en lançant une exception personnalisée
            // Vous pouvez également logger l'erreur pour un débogage ultérieur.
            throw new RuntimeException("Erreur lors de la lecture du fichier CV.", e);
        }

        Candidat candidat = new Candidat();
        candidat.setNom(nom);
        candidat.setPrenom(prenom);
        candidat.setEmail(email);
        candidat.setNumCin(numCin);
        candidat.setTel(tel);
        candidat.setDomaine(domaine);
        candidat.setPoste(poste);
        // Assignez d'autres champs du formulaire

        candidat.setCv(cvData);
        candidat.setCvNom(cvNom);
        candidat.setUser(user);

        // Enregistrez le candidat dans la base de données
        candidat = candidatRepo.save(candidat);

        return user;
    }*/

    @Transactional
    public List<Candidat> findAllCandidats() {
        return candidatRepo.findAll();
    }

    @Transactional
    public Candidat updateCandidat(Candidat candidat) {
        return candidatRepo.save(candidat);
    }

    @Transactional
    public Candidat findCandidatById(int id) {
        return candidatRepo.findCandidatById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    @Transactional
    public Candidat getProfileCandidat(int candidatId) {
        return candidatRepo.findCandidatById(candidatId)
                .orElseThrow(() -> new UserNotFoundException("User by id " + candidatId + " was not found"));

    }


    @Transactional
    public void deleteCandidat(int id) {
        candidatRepo.deleteCandidatById(id);
    }

   @Transactional
    public Candidat login(String email, String password) {
        Optional<Candidat> candidatOptional = candidatRepo.findCandidatByEmail(email);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();

            // Stockez l'ID du candidat dans la session avant de vérifier le mot de passe
            sessionUtil.setLoggedInCandidatId(candidat.getId());

            if (candidat.getPassword().equals(password)) {
                return candidat; // Connexion réussie
            }
        }

        // Si l'utilisateur n'est pas trouvé ou que le mot de passe ne correspond pas, vous pouvez générer une exception
        throw new UserNotFoundException("Invalid email or password");
    }
}




