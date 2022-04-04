package com.company.service;

import com.company.dto.request.StudentRequest;
import com.company.dto.response.StudentResponse;
import com.company.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getStudent();

    StudentResponse create(Long id, StudentRequest studentRequest);

    StudentResponse update(Long id, StudentRequest studentRequest);

    void delete(Long id);

    Student getStudentById(Long id);

    Optional<Student> findById(Long id);

}
