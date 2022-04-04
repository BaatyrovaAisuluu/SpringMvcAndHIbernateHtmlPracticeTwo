package com.company.mapper.edit;

import com.company.dto.request.CourseRequest;
import com.company.model.Course;
import com.company.repository.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public CourseEditMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Course create(Long id, CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public void Update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }
}
