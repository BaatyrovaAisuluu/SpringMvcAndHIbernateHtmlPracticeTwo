package com.company.dto.request;

import com.company.model.AuthInfo;
import com.company.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class TeacherRequest {

    private String TeacherFirstName;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnore
    private Course course;






}
