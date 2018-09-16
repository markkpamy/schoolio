package com.markkpamy.apiGestionEcole.Repository;

import com.markkpamy.apiGestionEcole.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Integer>,QuerydslPredicateExecutor{

}
