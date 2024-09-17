package com.atsin.learningspringboot.learningspringboot.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        if(number == null){
            return false;
        }
        return isPrime(number);
    }

    public boolean isPrime(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;

        return true;
    }

    @Override
    public void initialize(PrimeNumber constraintAnnotation) {
        //
    }
}
