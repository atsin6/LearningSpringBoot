package com.atsin.learningspringboot.learningspringboot.controllers;

import com.atsin.learningspringboot.learningspringboot.dto.EmployeeDTO;
import com.atsin.learningspringboot.learningspringboot.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret message: asfjo@#sdijDS";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    //Mapping employeeId to id
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    public String updatedEmployeeById(){
        return "Hello from PUT";
    }
}
