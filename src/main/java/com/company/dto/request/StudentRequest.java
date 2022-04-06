package com.company.dto.request;

import com.company.model.Group;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
public class StudentRequest {

    private String firstName;

    private String email;

    private String lastName;

    private String password;

    @Enumerated(EnumType.STRING)
    private com.company.model.studyFormat studyFormat;
    @JsonIgnore
    private Group groupId;
}
