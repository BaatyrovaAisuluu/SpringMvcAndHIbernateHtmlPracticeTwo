package com.company.dto.request;

import com.company.model.Company;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequest {

    private String courseName;

    private String duration;

    private Company companyId;

}
