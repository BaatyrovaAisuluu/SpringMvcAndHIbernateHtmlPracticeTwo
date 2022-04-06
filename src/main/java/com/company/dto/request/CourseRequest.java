package com.company.dto.request;

import com.company.model.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequest {

    private String courseName;

    private String duration;

    @JsonIgnore
    private Company companyId;

}
