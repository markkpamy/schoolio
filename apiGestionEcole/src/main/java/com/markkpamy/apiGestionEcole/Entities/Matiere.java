package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;

@Entity
@Table(name = "matiere")
public class Matiere {

    public Matiere() {
    }

    public Matiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matiere matiere = (Matiere) o;

        if (idMatiere != matiere.idMatiere) return false;
        return nomMatiere.equals(matiere.nomMatiere);
    }

    @Override
    public int hashCode() {
        int result = idMatiere;
        result = 31 * result + nomMatiere.hashCode();
        return result;
    }

    @Id
    @Column(name = "idMatiere", nullable = false)
    private int idMatiere;

    @Override
    public String toString() {
        return "Matiere{" +
                "idMatiere=" + idMatiere +
                ", nomMatiere='" + nomMatiere + '\'' +
                '}';
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    @Basic
    @Column(name = "NomMatiere", nullable = true, length = 45)
    private String nomMatiere;

    public String getNomMatiere() {
        return nomMatiere;
    }

    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "matieres")
    private Set<Professeur> professeurs = new HashSet<>();

/*
    @OneToMany(mappedBy = "matiere")
    private Set<Absence> absences = new HashSet<>();*/

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

}
