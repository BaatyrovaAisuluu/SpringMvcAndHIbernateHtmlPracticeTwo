package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teachers")
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "teacher_sequence"
    )
    private Long id;

    @Size(min = 1, max = 30, message = "firstName should be between 2 and 25 characters")
    private String TeacherFirstName;

    @Email(message = "email must follow the formatter: ***@*** ")
    private String email;

    @Size(min = 1, max = 25, message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @OneToOne(cascade = {MERGE, DETACH, REFRESH, PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;
}
