package com.markkpamy.apiGestionEcole.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classe {
    @Id
    @Column(name = "idClasse", nullable = false)
    private int idClasse;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    @Basic
    @Column(name = "NomClasse", nullable = true, length = 45)
    private String nomClasse;

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Responsable", nullable = true)
    private Professeur responsable;

    public Professeur getResponsable() {
        return responsable;
    }

    public void setResponsable(Professeur responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "nomClasse='" + nomClasse + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "classe")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
