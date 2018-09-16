package com.markkpamy.apiGestionEcole.Controllers;

import com.markkpamy.apiGestionEcole.Entities.Student;
import com.markkpamy.apiGestionEcole.Models.CustomPageRequest;
import com.markkpamy.apiGestionEcole.Models.PageResponse;
import com.markkpamy.apiGestionEcole.Service.StudentService;
import com.markkpamy.apiGestionEcole.ViewsModels.StudentViewModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/students"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping(path = {"/{id}"})
    public Student findOne(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Student update(@PathVariable("id") int id, @RequestBody Student student){
        student.setId_eleve(id);
        return studentService.update(student);
    }

    @DeleteMapping(path ={"/{id}"})
    public Student delete(@PathVariable("id") int id) {
        return studentService.delete(id);
    }

    @PostMapping("/getstudents")
    public PageResponse<StudentViewModel> findAll(@RequestBody CustomPageRequest customPageRequest){
        return createResponse(studentService.findStudents(customPageRequest));
    }

    private PageResponse<StudentViewModel> createResponse(Page<Student> studentPage) {
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<StudentViewModel>>() {}.getType();
        List<StudentViewModel> studentViewModelList = modelMapper.map(studentPage.getContent(),listType);
        PageResponse<StudentViewModel> studentPageResponse = new PageResponse<>();
        studentPageResponse.setResults(studentViewModelList);
        studentPageResponse.setTotalElements(studentPage.getTotalElements());
        studentPageResponse.setTotalPages(studentPage.getTotalPages());

        return studentPageResponse;
    }
}
