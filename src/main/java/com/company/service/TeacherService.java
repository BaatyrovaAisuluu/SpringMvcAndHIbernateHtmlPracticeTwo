package com.company.service;

import com.company.dto.request.TeacherRequest;
import com.company.dto.response.TeacherResponse;
import com.company.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getTeacher();

    TeacherResponse create(Long id, TeacherRequest teacherRequest);

    TeacherResponse update(Long id, TeacherRequest teacherRequest);

    void delete(Long id);

    Teacher getTeacherById(Long id);

    Optional<Teacher> findById(Long id);

    Teacher saveAdmin(Teacher teacher);

}
