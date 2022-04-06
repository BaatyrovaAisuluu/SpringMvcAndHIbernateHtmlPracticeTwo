package com.company.api;

import com.company.dto.request.CourseRequest;
import com.company.dto.response.CourseResponse;
import com.company.model.Company;
import com.company.model.Course;
import com.company.service.CompanyService;
import com.company.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER','STUDENT')")
    @Operation(summary = "get All Course")
    public List<Course> getCourse() {
        return courseService.getCourse();

    }

    @PostMapping("/saveCourse")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "save Course")
    public CourseResponse createCourse(@PathVariable("id") Long id,
                                       @RequestBody CourseRequest courseRequest) {
        courseRequest.setCompanyId(companyService.getCompanyById(id));
        return courseService.create(id, courseRequest);
    }

    @PatchMapping("/update/{updateId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "update Course")
    public CourseResponse updateCourse(@PathVariable Long id,
                                       @RequestBody CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "delete Course")
    public void deleteCourseId(@PathVariable("deleteId") Long id) {
        courseService.delete(id);
    }

    @GetMapping("/courseId/{CourseId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "getById Course")
    public Course getCourseById(@PathVariable("CourseId") Long id) {
        return courseService.findById(id);
    }

}
