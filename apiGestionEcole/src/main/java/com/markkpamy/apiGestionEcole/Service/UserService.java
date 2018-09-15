package com.markkpamy.apiGestionEcole.Service;

import com.markkpamy.apiGestionEcole.Entities.Student;

import java.util.List;

public interface UserService {

    Student create(Student student);

    Student delete(int id);

    List<Student> findAll();

    Student findById(int id);

    Student update(Student student);
}
