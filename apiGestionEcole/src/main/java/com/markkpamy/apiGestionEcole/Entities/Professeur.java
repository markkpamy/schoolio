package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professeur")
public class Professeur {

    @Id
    @Column(name = "id_professeur", nullable = false)
    private int id_professeur;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_employe", nullable = false)
    private Employe employe;

    @Basic
    @Column(name = "grade", nullable = true, length = 45)
    private String grade;

    public String getGrade() {
        return grade;
    }
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "corresp_matiere_professeur", joinColumns = @JoinColumn(name = "id_professeur"), inverseJoinColumns = {@JoinColumn(name = "id_matiere")})
    private Set<Matiere> matieres=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "corresp_classe_professeur", joinColumns = @JoinColumn(name = "id_professeur"), inverseJoinColumns = {@JoinColumn(name = "id_classe")})
    private Set<Classe> classes=new HashSet<>();

    public int getId_professeur() {
        return id_professeur;
    }

    public void setId_professeur(int id_professeur) {
        this.id_professeur = id_professeur;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Set<Matiere> getMatieres() {
        return matieres;
    }

    public Professeur(Employe employe) {
        this.employe = employe;
    }

    public void setMatieres(Set<Matiere> matieres) {

        this.matieres = matieres;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Professeur{" +
                "id_professeur=" + id_professeur +
                ", employe=" + employe +
                ", grade='" + grade + '\'' +
                ", matieres=" + matieres.toString() +
                ", classes=" + classes.toString() +
                '}';
    }
}
