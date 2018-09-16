package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "matiere")
public class Matiere implements Serializable {

    @Id
    @Column(name = "id_matiere", nullable = false)
    private int id_matiere;

    @Basic
    @Column(name = "nom_matiere", nullable = true, length = 45)
    private String nom_matiere;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matiere matiere = (Matiere) o;

        if (id_matiere != matiere.id_matiere) return false;
        return nom_matiere.equals(matiere.nom_matiere);
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id_matiere=" + id_matiere +
                ", nom_matiere='" + nom_matiere + '\'' +
                '}';
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "matieres")
    private Set<Professeur> professeurs = new HashSet<>();

/*
    @OneToMany(mappedBy = "matiere")
    private Set<Absence> absences = new HashSet<>();*/

}
