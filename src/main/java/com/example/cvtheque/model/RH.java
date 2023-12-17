package com.example.cvtheque.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rh")
public class RH implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
  /*  @OneToOne
    @JoinColumn(name = "user_id")
    private User user;*/
    public RH( int id,String nom, String prenom, String email, String password) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }



    public RH() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RH{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
