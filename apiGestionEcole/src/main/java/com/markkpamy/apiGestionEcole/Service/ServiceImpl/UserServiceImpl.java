package com.markkpamy.apiGestionEcole.Service.ServiceImpl;

import com.markkpamy.apiGestionEcole.Entities.Student;
import com.markkpamy.apiGestionEcole.Repository.UserRepository;
import com.markkpamy.apiGestionEcole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student delete(int id) {
        Student student = findById(id);
        if(student != null){
            repository.delete(student);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }
}
