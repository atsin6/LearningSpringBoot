package com.atsin.learningspringboot.learningspringboot.dto;

import com.atsin.learningspringboot.learningspringboot.annotations.PrimeNumber;
import jakarta.persistence.criteria.CriteriaBuilder;

public class NumberDTO {

    @PrimeNumber(message = "Please provide a valid prime number")
    private Integer number;
}
