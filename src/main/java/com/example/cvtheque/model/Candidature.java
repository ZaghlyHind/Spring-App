package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidature")
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String etat;

    @Column(nullable = false)
    private Date datePostulation;

    @ManyToOne
    @JoinColumn(name = "idCandidat")
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "idOffre")
    private Poste poste;
    @OneToMany(mappedBy = "candidature")
    private List<OffreCDI> offresCDI;
    public Candidature() {
        // Constructeur par défaut nécessaire pour JPA
    }

    // Constructeur avec les champs requis
    public Candidature(Candidat candidat, Poste poste) {
        this.etat = "En attente";
        this.datePostulation = new Date();
        this.candidat = candidat;
        this.poste = poste;
    }

    // Getters et setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(Date datePostulation) {
        this.datePostulation = datePostulation;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
}
