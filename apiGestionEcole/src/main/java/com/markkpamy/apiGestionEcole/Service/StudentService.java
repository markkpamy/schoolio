package com.markkpamy.apiGestionEcole.Service;

import com.markkpamy.apiGestionEcole.Entities.Student;
import com.markkpamy.apiGestionEcole.Models.CustomPageRequest;
import org.springframework.data.domain.Page;

public interface StudentService {

    Student create(Student student);

    Student delete(int id);

    Page findStudents(CustomPageRequest pageRequest);

    Student findById(int id);

    Student update(Student student);
}
