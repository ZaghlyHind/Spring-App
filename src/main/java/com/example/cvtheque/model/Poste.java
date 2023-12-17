package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "poste")
public class Poste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mission;
    private String domaine;
    private String ville;
    private String client;
    private String qualifications;
    private String typeContrat;
    private String intitulePoste;

    public Poste(){}

    public Poste(Long id, String mission, String domaine, String ville, String client, String qualifications, String typeContrat, String intitulePoste) {
        this.id = id;
        this.mission = mission;
        this.domaine = domaine;
        this.ville = ville;
        this.client = client;
        this.qualifications = qualifications;
        this.typeContrat = typeContrat;
        this.intitulePoste = intitulePoste;
    }

    public Poste(String mission, String domaine, String ville, String client, String qualifications, String typeContrat, String intitulePoste) {
        this.mission = mission;
        this.domaine = domaine;
        this.ville = ville;
        this.client = client;
        this.qualifications = qualifications;
        this.typeContrat = typeContrat;
        this.intitulePoste = intitulePoste;
    }

    public Long getId() {
        return id;
    }

    public String getMission() {
        return mission;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getVille() {
        return ville;
    }

    public String getClient() {
        return client;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "id=" + id +
                ", mission='" + mission + '\'' +
                ", domaine='" + domaine + '\'' +
                ", ville='" + ville + '\'' +
                ", client='" + client + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", typeContrat='" + typeContrat + '\'' +
                ", intitulePoste='" + intitulePoste + '\'' +
                '}';
    }
}
