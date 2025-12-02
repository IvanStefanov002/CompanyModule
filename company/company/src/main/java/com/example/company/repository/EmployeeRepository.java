package com.example.company.repository;

import com.example.company.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findAllByPosition(String position);
}
