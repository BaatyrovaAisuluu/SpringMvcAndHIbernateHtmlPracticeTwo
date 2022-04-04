package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@NoArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_sequence"
    )
    private Long id;

    @NotEmpty(message = "groupName should not be empty")
    @Size(min = 2, max = 10, message = "groupName should be between 2 and 10 characters")
    private String groupName;

    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(cascade = {MERGE, REFRESH, PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "courses_groups",
            joinColumns = @JoinColumn(name = "groups_id"), inverseJoinColumns
            = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List<Course> course;

    @OneToMany(cascade = ALL, mappedBy = "group")
    private List<Student> studentList;

    public void AddCourse(Course courses) {
        if (this.course == null) {
            this.course = new ArrayList<>();
        }

        this.course.add(courses);

    }

}
