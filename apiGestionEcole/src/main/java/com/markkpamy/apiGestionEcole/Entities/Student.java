package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eleve")
public class Student {

    @Id
    @Column(name = "id_eleve", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_eleve;

    @Basic
    @Column(name = "nom", nullable = true, length = 45)
    private String nom;

    @Basic
    @Column(name = "prenom", nullable = true, length = 45)
    private String prenom;

    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance", nullable = true, length = 45)
    private Date date_naissance;

    @Column(name = "lieu_naissance", nullable = true, length = 45)
    private String lieu_naissance;

    @Column(name = "adresse", nullable = true, length = 45)
    private String adresse;

    @Column(name = "telephone", nullable = true, length = 45)
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe", nullable = true)
    private Classe classe;

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
