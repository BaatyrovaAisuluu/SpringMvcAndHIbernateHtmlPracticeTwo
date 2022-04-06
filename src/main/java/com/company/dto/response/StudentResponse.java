package com.company.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String id;

    private String firstName;


    private String lastName;

    private com.company.model.studyFormat studyFormat;
}
