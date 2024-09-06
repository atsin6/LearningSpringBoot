package com.atsin.learningspringboot.learningspringboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


//Hibernate converts Entities to table inside the Database
@Entity
//Below 4 notations are lombok dependency notations that are used to use Getters Setters and Constructors etc.
// in our code without manually writing code for these
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private Double salary;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

}
