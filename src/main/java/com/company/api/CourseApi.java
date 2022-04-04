package com.company.api;

import com.company.dto.request.CourseRequest;
import com.company.dto.response.CourseResponse;
import com.company.model.Company;
import com.company.model.Course;
import com.company.service.CompanyService;
import com.company.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course/{id}")
public class CourseApi {

    private final CompanyService companyService;
    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getCourse();

    }

    @PostMapping("/saveCourse")
    public CourseResponse createCourse(@PathVariable("id") Long id,
                                       @RequestBody CourseRequest courseRequest) {
        courseRequest.setCompanyId(companyService.getCompanyById(id));
        return courseService.create(id, courseRequest);
    }

    @PatchMapping("/update/{updateId}")
    public CourseResponse updateCourse(@PathVariable Long id,
                                       @RequestBody CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void deleteCourseId(@PathVariable("deleteId") Long id) {
        courseService.delete(id);
    }

    @GetMapping("/courseId/{CourseId}")
    public Course getCourseById(@PathVariable("CourseId") Long id) {
        return courseService.findById(id);
    }

}
