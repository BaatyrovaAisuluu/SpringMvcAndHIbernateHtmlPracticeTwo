package com.company.mapper.view;

import com.company.dto.response.CourseResponse;
import com.company.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(String.valueOf(course.getId()));
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;

    }

    public List<CourseResponse> viewCourses(List<Course> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course c : courses
        ) {
            courseResponses.add(viewCourse(c));
        }
        return courseResponses;
    }

}
