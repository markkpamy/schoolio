package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classe {
    @Id
    @Column(name = "id_classe", nullable = false)
    private int id_classe;

    @Basic
    @Column(name = "nom_classe", nullable = true, length = 45)
    private String nom_classe;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsable", nullable = true)
    private Professeur responsable;

    @OneToMany(mappedBy = "classe", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public Professeur getResponsable() {
        return responsable;
    }

    public void setResponsable(Professeur responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "nom_classe='" + nom_classe + '\'' +
                '}';
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
