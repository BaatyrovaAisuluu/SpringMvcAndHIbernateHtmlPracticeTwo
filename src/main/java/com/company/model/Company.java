package com.company.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;

    @NotEmpty(message = "companyName should not be empty")
    @Size(min = 1, max = 25, message = "companyName should be between 2 and 25 characters")
    private String companyName;

    @NotEmpty(message = "LocatedCountry should not be empty")
    @Size(min = 1, max = 25, message = "locatedCountry should be between 2 and 25 characters")
    private String locatedCountry;

    @OneToMany(cascade = {MERGE, REMOVE, REFRESH, DETACH, PERSIST}, mappedBy = "company")
    private List<Course> courseList;
}
