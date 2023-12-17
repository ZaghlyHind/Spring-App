package com.example.cvtheque.model;

public class InscriptionRequest {
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String poste;
    private String domaine;
    private String tel;
    private String numCin;
    private String cvNom;
    private byte[] cv;


    public InscriptionRequest() {
    }

    public InscriptionRequest(String email, String password, String nom, String prenom, String poste, String domaine, String tel, String numCin, String cvNom, byte[] cv) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.domaine = domaine;
        this.tel = tel;
        this.numCin = numCin;
        this.cvNom = cvNom;
        this.cv = cv;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNumCin() {
        return numCin;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public String getCvNom() {
        return cvNom;
    }

    public void setCvNom(String cvNom) {
        this.cvNom = cvNom;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
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
}
