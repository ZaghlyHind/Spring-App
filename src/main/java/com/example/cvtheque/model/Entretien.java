package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String retourClient;
    @ManyToOne
    @JoinColumn(name = "idCandidature") // Cette annotation spécifie la clé étrangère
    private Candidature candidature; // Relation avec Candidature
    public Entretien() {
    }

    public Entretien(int id, Date date, String retourClient) {
        this.id = id;
        this.date = date;
        this.retourClient = retourClient;
    }

    public Entretien(int id, Date date, String retourClient, Candidature candidature) {
        this.id = id;
        this.date = date;
        this.retourClient = retourClient;
        this.candidature = candidature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRetourClient() {
        return retourClient;
    }

    public void setRetourClient(String retourClient) {
        this.retourClient = retourClient;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

}
