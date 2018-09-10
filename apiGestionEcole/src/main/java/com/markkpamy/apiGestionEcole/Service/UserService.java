package com.markkpamy.apiGestionEcole.Service;

import com.markkpamy.apiGestionEcole.Entities.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User delete(int id);

    List<User> findAll();

    User findById(int id);

    User update(User user);
}
