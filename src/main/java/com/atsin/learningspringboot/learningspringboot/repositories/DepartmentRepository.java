package com.atsin.learningspringboot.learningspringboot.repositories;

import com.atsin.learningspringboot.learningspringboot.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
