package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professeur")
public class Professeur {

    @Id
    @Column(name = "idProfesseur", nullable = false)
    private int idProfesseur;
    public int getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Professeur() {
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEmploye", nullable = false)
    private Employe employe;

    @Basic
    @Column(name = "Grade", nullable = true, length = 45)
    private String grade;
    public String getGrade() {
        return grade;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "correspmatiereprofesseur", joinColumns = @JoinColumn(name = "idProfesseur"), inverseJoinColumns = {@JoinColumn(name = "idMatiere")})
    private Set<Matiere> matieres=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "correspClasseProf", joinColumns = @JoinColumn(name = "idProfesseur"), inverseJoinColumns = {@JoinColumn(name = "idClasse")})
    private Set<Classe> classes=new HashSet<>();

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

    @Override
    public String toString() {
        return "Professeur{" +
                "idProfesseur=" + idProfesseur +
                ", employe=" + employe +
                ", grade='" + grade + '\'' +
                ", matieres=" + matieres.toString() +
                ", classes=" + classes.toString() +
                '}';
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }
}
