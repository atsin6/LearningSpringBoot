package com.atsin.learningspringboot.learningspringboot.services;

import com.atsin.learningspringboot.learningspringboot.dto.DepartmentDTO;
import com.atsin.learningspringboot.learningspringboot.entities.DepartmentEntity;
import com.atsin.learningspringboot.learningspringboot.exceptions.ResourceNotFoundException;
import com.atsin.learningspringboot.learningspringboot.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveDepartmentEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveDepartmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, Map<String, Object> updates) {
        isExistByDepartmentId(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });

        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(Long departmentId) {
        isExistByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    private void isExistByDepartmentId(Long departmentId) {
        boolean exist = departmentRepository.existsById(departmentId);
        if(!exist) throw new ResourceNotFoundException("Department was not found with ID : "+departmentId);
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        boolean exist = departmentRepository.existsById(departmentId);
        if(exist) return modelMapper.map(departmentRepository.getReferenceById(departmentId), DepartmentDTO.class);
        throw new ResourceNotFoundException("Department was not found with Id : "+departmentId);
    }
}
