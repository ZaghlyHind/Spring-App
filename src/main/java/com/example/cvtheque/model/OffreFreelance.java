package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "offreFreelance")
public class OffreFreelance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String TJM;
    private Date dateDebut;
    private Date dateFin;
    private String margeBenefice;
    public OffreFreelance(Long id, String TJM, Date dateDebut, Date dateFin, String margeBenefice) {
        this.id = id;
        this.TJM = TJM;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.margeBenefice = margeBenefice;
    }

    public OffreFreelance() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setTJM(String TJM) {
        this.TJM = TJM;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setMargeBenefice(String margeBenefice) {
        this.margeBenefice = margeBenefice;
    }

    public Long getId() {
        return id;
    }

    public String getTJM() {
        return TJM;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getMargeBenefice() {
        return margeBenefice;
    }

    @Override
    public String toString() {
        return "OffreFreelance{" +
                "id=" + id +
                ", TJM='" + TJM + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", margeBenefice='" + margeBenefice + '\'' +
                '}';
    }
}
