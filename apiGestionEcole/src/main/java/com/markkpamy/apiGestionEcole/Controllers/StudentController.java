package com.markkpamy.apiGestionEcole.Controllers;

import com.markkpamy.apiGestionEcole.Entities.Student;
import com.markkpamy.apiGestionEcole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/students"})
public class StudentController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Student create(@RequestBody Student student){
        return userService.create(student);
    }

    @GetMapping(path = {"/{id}"})
    public Student findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Student update(@PathVariable("id") int id, @RequestBody Student student){
        student.setId(id);
        return userService.update(student);
    }

    @DeleteMapping(path ={"/{id}"})
    public Student delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<Student> findAll(){
        return userService.findAll();
    }
}
