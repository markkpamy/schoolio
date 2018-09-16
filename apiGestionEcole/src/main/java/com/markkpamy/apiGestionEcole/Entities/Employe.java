package com.markkpamy.apiGestionEcole.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "employe")
public class Employe implements Serializable {

    @Id
    @Column(name = "id_employe", nullable = false)
    private int id_employe;

    @Basic
    @Column(name = "nom", nullable = true, length = 45)
    private String nom;

    @Basic
    @Column(name = "prenom", nullable = true, length = 45)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance", nullable = true, length = 45)
    private Date date_naissance;

    @Basic
    @Column(name = "lieu_naissance", nullable = true, length = 45)
    private String lieu_naissance;

    @Basic
    @Column(name = "adresse", nullable = true, length = 45)
    private String adresse;

    @Basic
    @Column(name = "statut", nullable = true, length = 45)
    private int statut;

    @Basic
    @Column(name = "telephone", nullable = true, length = 45)
    private String telephone;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Basic
    @Column(name = "date_recrutement", nullable = true)
    private Date date_recrutement;

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

}
