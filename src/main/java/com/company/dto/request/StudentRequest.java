package com.company.dto.request;

import com.company.model.Group;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRequest {

    private String firstName;

    private String email;

    private String lastName;

    private com.company.model.studyFormat studyFormat;

    private Group groupId;
}
