package com.atsin.learningspringboot.learningspringboot.controllers;

import com.atsin.learningspringboot.learningspringboot.dto.NumberDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @PostMapping("/check-prime")
    public ResponseEntity<String> checkPrimeNumber(@Valid @RequestBody NumberDTO numberDTO){
        return ResponseEntity.ok("This is a prime Number!");
    }

}
