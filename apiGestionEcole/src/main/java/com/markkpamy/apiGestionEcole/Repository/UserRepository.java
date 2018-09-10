package com.markkpamy.apiGestionEcole.Repository;

import com.markkpamy.apiGestionEcole.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {

}
