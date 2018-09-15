package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employe")
public class Employe {

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
    @Column(name = "adresse", nullable = true, length = 45)
    private String adresse;

    @Basic
    @Column(name = "statut", nullable = true, length = 45)
    private String statut;

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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;

        if (id_employe != employe.id_employe) return false;
        if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
        if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
        if (date_naissance != null ? !date_naissance.equals(employe.date_naissance) : employe.date_naissance != null)
            return false;
        if (adresse != null ? !adresse.equals(employe.adresse) : employe.adresse != null) return false;
        if (telephone != null ? !telephone.equals(employe.telephone) : employe.telephone != null) return false;
        if (email != null ? !email.equals(employe.email) : employe.email != null) return false;
        if (statut != null ? !statut.equals(employe.statut) : employe.statut != null) return false;
        if (date_recrutement != null ? !date_recrutement.equals(employe.date_recrutement) : employe.date_recrutement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_employe;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (date_naissance != null ? date_naissance.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (date_recrutement != null ? date_recrutement.hashCode() : 0);
        return result;
    }
}
