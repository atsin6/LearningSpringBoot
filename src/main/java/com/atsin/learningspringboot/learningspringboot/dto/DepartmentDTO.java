package com.atsin.learningspringboot.learningspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long DepartmentId;

    @NotBlank(message = "Name of the department cannot be Blank")
    private String title;

    @JsonProperty("isActive")
    private Boolean isActive;

    @Past(message = "Date of creation of Department should be in Past")
    private LocalDateTime createdAt;
}
