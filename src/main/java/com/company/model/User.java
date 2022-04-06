package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.ALL;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "user_sequence"
    )
    private Long id;

    @Size(min = 1, max = 30, message = "firstName should be between 2 and 25 characters")
    private String FirstName;

    @Size(min = 1, max = 25, message = "lastName should be between 2 and 25 characters")
    private String lastName;

    @OneToOne(cascade = ALL)
    private AuthInfo authInfo;
}
