package com.company.dto.response;

import com.company.model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {

    private String id;
    private String companyName;
    private String locatedCountry;
    //private List<Course> courses;
}
