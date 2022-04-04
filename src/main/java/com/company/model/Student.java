package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "student_sequence"
    )
    private Long id;

    @NotEmpty(message = "firstName should not be empty")
    @Size(min = 1, max = 25, message = "firstName should be between 2 and 25 characters")
    private String firstName;

    @Column(name = "student_email")
    @Email(message = "email must follow the formatter: ***@*** ")
    @NotBlank(message = "Email must have a value")
    private String email;

    @Column(name = "student_last_name")
    @NotEmpty(message = "lastName should not be empty")
    @Size(min = 1, max = 25, message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private studyFormat studyFormat;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    @JsonIgnore
    private Group group;

}
