package com.markkpamy.apiGestionEcole.Service.ServiceImpl;

import com.markkpamy.apiGestionEcole.Entities.QueryDsl.QStudent;
import com.markkpamy.apiGestionEcole.Entities.Student;
import com.markkpamy.apiGestionEcole.Models.CustomPageRequest;
import com.markkpamy.apiGestionEcole.Models.Filter;
import com.markkpamy.apiGestionEcole.Repository.StudentRepository;
import com.markkpamy.apiGestionEcole.Service.StudentService;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(int id) {
        Student student = findById(id);
        if (student != null) {
            studentRepository.delete(student);
        }
        return student;
    }

    @Override
    public Page<Student> findStudents(CustomPageRequest customPageRequest) {
        List<BooleanExpression> filters = extractFilters(customPageRequest);
        if (!filters.isEmpty()) {
            return studentRepository.findAll(
                    chainFiltersWithAnd(filters),
                    PageRequest.of(customPageRequest.getPage(), customPageRequest.getSize(), Sort.by(customPageRequest.getSortDirection(), customPageRequest.getSortField()))
            );
        } else {
            return studentRepository.findAll(
                    PageRequest.of(
                            customPageRequest.getPage(),
                            customPageRequest.getSize(),
                            Sort.by(customPageRequest.getSortDirection(),
                                    customPageRequest.getSortField() == null ? "prenom" : customPageRequest.getSortField()))
            );
        }
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    private BooleanExpression chainFiltersWithAnd(List<BooleanExpression> filters) {
        BooleanExpression result = null;
        for (BooleanExpression booleanExpression : filters) {
            if (result == null) {
                result = booleanExpression;
            } else {
                result = result.and(booleanExpression);
            }
        }
        return result;
    }

    private List<BooleanExpression> extractFilters(CustomPageRequest studentPageRequest) {
        List<BooleanExpression> filters = new ArrayList<>();
        QStudent student = QStudent.student;
        if (studentPageRequest.getFilters() != null) {
            List<Filter> pageRequestFiltersfilters = studentPageRequest.getFilters();
            for (Filter pageRequestFilter : pageRequestFiltersfilters) {
                switch (pageRequestFilter.getKey()) {
                    case "id_eleve":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.id_eleve.eq(Integer.valueOf(filterValue)));
                        }
                        break;
                    case "prenom":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.prenom.containsIgnoreCase(filterValue));
                        }
                        break;
                    case "nom":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.nom.containsIgnoreCase(filterValue));
                        }
                        break;
                    case "lieu_naissance":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.lieu_naissance.containsIgnoreCase(filterValue));
                        }
                        break;
                    case "telephone":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.telephone.containsIgnoreCase(filterValue));
                        }
                        break;
                    case "email":
                        for (String filterValue : pageRequestFilter.getValue()) {
                            filters.add(student.email.containsIgnoreCase(filterValue));
                        }
                        break;
                }
            }

        }
        return filters;
    }


}