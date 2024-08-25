package com.atsin.learningspringboot.learningspringboot.repositories;

import com.atsin.learningspringboot.learningspringboot.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    /**
     * Before Hibernate, We have to define the repository.
     * We have create methods that actually perform the queries to get the data by ID, to delete the data, to save the data.
     * But now we done all above things using spring data JPA.
     * It define the CRUD operations and some complex queries are also defined with the help of JPQL.
     */


    /**
     *
     * It is not recommended to connect the JPA repository directly to the controller.
     * We should always have a separate layer in between which is the service layer that will connect to the JPA repository.
     */
}
