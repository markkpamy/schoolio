package com.markkpamy.apiGestionEcole.Repository;

import com.markkpamy.apiGestionEcole.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<Student, Integer> {

}
