package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor

@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;

    @NotEmpty(message = "courseName  should not be empty")
    @Size(min = 1, max = 15, message = "courseName should be between 3 and 15 characters")
    private String courseName;

    @NotEmpty(message = "format mm")
    private String duration;

    @ManyToMany(cascade = {MERGE, REMOVE, PERSIST, REFRESH, DETACH}, fetch = FetchType.LAZY, mappedBy = "course")

    private List<Group> groupList;

    @OneToOne(cascade = {MERGE, REMOVE, DETACH, MERGE}, mappedBy = "course", fetch = FetchType.EAGER)
    private Teacher teacher;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;
}
