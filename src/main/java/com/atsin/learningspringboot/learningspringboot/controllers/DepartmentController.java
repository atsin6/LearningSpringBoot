package com.atsin.learningspringboot.learningspringboot.controllers;

import com.atsin.learningspringboot.learningspringboot.dto.DepartmentDTO;
import com.atsin.learningspringboot.learningspringboot.dto.EmployeeDTO;
import com.atsin.learningspringboot.learningspringboot.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(@RequestParam(required = false, name = "isActive") Boolean isActive){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody Map<String, Object> updates, @PathVariable Long departmentId){
        DepartmentDTO departmentDTO = departmentService.updateDepartmentById(departmentId, updates);
        if(departmentDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        Boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
