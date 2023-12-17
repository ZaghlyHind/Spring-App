package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "offreCDI")
public class OffreCDI implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String preavis;
    private Date dateDebut;
    private String salaire;
    @ManyToOne
    @JoinColumn(name = "idCandidature")
    private Candidature candidature;

    public OffreCDI(Long id, String preavis, Date dateDebut, String salaire) {
        this.id = id;
        this.preavis = preavis;
        this.dateDebut = dateDebut;
        this.salaire = salaire;
    }

    public OffreCDI(String preavis, Date dateDebut, String salaire) {
        this.preavis = preavis;
        this.dateDebut = dateDebut;
        this.salaire = salaire;
    }

    public OffreCDI(){}

    public Long getId() {
        return id;
    }

    public String getPreavis() {
        return preavis;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreavis(String preavis) {
        this.preavis = preavis;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "OffreCDI{" +
                "id=" + id +
                ", preavis='" + preavis + '\'' +
                ", dateDebut=" + dateDebut +
                ", salaire='" + salaire + '\'' +
                '}';
    }
}
