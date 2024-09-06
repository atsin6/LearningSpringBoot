package com.atsin.learningspringboot.learningspringboot.dto;

import com.atsin.learningspringboot.learningspringboot.annotations.EmployeeRoleValidation;
import com.atsin.learningspringboot.learningspringboot.annotations.EmployeeRoleValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
       private Long id;

       @NotBlank(message = "Name of the employee cannot be Blank")
       @Size(min = 3, max = 15, message = "Number of characters should be in the range 3-15")
       private String name;

       @Email(message = "Email should be a valid email")
       private String email;

       @NotNull(message = "Age of the employee cannot be blank")
       @Max(value = 62, message = "Age cannot be greater than 63")
       @Min(value = 18, message = "Age cannot be smaller than 18")
       private Integer age;

       @NotBlank(message = "Role of the employee cannot be blank")
//       @Pattern(regexp = "^(ADMIN|USER)$", message = "The role of the employee should be ADMIN or USER only")
       @EmployeeRoleValidation
       private String role;


       @NotNull(message = "Salary of employee should not be null")
       @Positive(message = "Salary of employee should be positive")
       @Digits(integer = 7, fraction = 2, message = "salary can be in the form XXXXXXX.YY")
       @DecimalMin(value = "100.00")
       @DecimalMax(value = "9999999.99")
       private Double salary;

       @PastOrPresent(message = "Date of Joining should be a Past or a Present date")
       private LocalDate dateOfJoining;

       @AssertTrue(message = "Employee should be active")
       @JsonProperty("isActive")
       private Boolean isActive;
}
