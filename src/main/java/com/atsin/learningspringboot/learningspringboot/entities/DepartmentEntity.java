package com.atsin.learningspringboot.learningspringboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DepartmentId;

    private String title;

    @JsonProperty("isActive")
    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
