package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employe")
public class Employe {


    public Employe() {
    }

    @Id
    @Column(name = "idEmploye", nullable = false)
    private int idEmploye;

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    @Basic
    @Column(name = "Nom", nullable = true, length = 45)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom", nullable = true, length = 45)
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DateNaissance", nullable = true, length = 45)
    private Date dateNaissance;

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "Adresse", nullable = true, length = 45)
    private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, length = 45)
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 45)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Statut", nullable = true, length = 45)
    private String statut;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Basic
    @Column(name = "DateRecrutement", nullable = true)
    private Date dateRecrutement;

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;

        if (idEmploye != employe.idEmploye) return false;
        if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
        if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
        if (dateNaissance != null ? !dateNaissance.equals(employe.dateNaissance) : employe.dateNaissance != null)
            return false;
        if (adresse != null ? !adresse.equals(employe.adresse) : employe.adresse != null) return false;
        if (telephone != null ? !telephone.equals(employe.telephone) : employe.telephone != null) return false;
        if (email != null ? !email.equals(employe.email) : employe.email != null) return false;
        if (statut != null ? !statut.equals(employe.statut) : employe.statut != null) return false;
        if (dateRecrutement != null ? !dateRecrutement.equals(employe.dateRecrutement) : employe.dateRecrutement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmploye;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (dateRecrutement != null ? dateRecrutement.hashCode() : 0);
        return result;
    }
}
