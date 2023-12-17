package com.example.cvtheque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "candidat")
public class Candidat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String numCin;
    private String nom;
    private String prenom;
    private String email;
    private String domaine;
    private String tel;
    private String poste;
    private String password;
    private String cvNom;
    @Lob
    @Column(name = "cv", columnDefinition = "MEDIUMBLOB")
    private byte[] cv;
  /*  @OneToOne
    @JoinColumn(name = "user_id")
    private User user;*/
    @OneToMany(mappedBy = "candidat")

    private List<Candidature> candidatures;
    public Candidat() {}

    public Candidat(int id, String numCin, String nom, String prenom, String password,String email, String domaine, String tel, String poste, byte[] cv) {
        this.id = id;
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.domaine = domaine;
        this.tel = tel;
        this.poste = poste;
        this.cv = cv;
        this.password=password;

    }

    public String getCvNom() {
        return cvNom;
    }

    public void setCvNom(String cvNom) {
        this.cvNom = cvNom;
    }

    public Candidat(String numCin, String nom, String prenom, String email,String password, String domaine, String tel, String poste) {
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.domaine = domaine;
        this.tel = tel;
        this.poste = poste;
        this.password=password;

    }

    public Candidat(int id, String numCin, String nom, String prenom, String password,String email, String domaine, String tel, String poste,  String cvNom) {
        this.id = id;
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.domaine = domaine;
        this.tel = tel;
        this.poste = poste;
        this.cvNom=cvNom;
        this.password=password;
    }
   /* @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id") // Nom de la colonne de clé étrangère
    private User user;*/

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public String getNumCin() {
        return numCin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getTel() {
        return tel;
    }

    public String getPoste() {
        return poste;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }


    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", numCin='" + numCin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", domaine='" + domaine + '\'' +
                ", tel='" + tel + '\'' +
                ", poste='" + poste + '\'' +

                '}';
    }
}
