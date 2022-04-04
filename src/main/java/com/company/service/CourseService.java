package com.company.service;

import com.company.dto.request.CourseRequest;
import com.company.dto.response.CourseResponse;
import com.company.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getCourse();

    CourseResponse create(Long id, CourseRequest courseRequest);

    CourseResponse update(Long id, CourseRequest courseRequest);

    void delete(Long id);

    Course getCourseById(Long id);

    Course findById(Long id);

}
