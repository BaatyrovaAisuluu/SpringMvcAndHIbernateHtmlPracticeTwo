package com.company.dto.request;

import com.company.model.Course;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherRequest {

    private String TeacherFirstName;
    private String email;
    private String lastName;
    private Course course;

}
