package com.example.company.service;

import com.example.company.model.Employee;
import com.example.company.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private final EmployeeRepository repository;

    public EmployeesService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployeesByPosition(String position) {
        return repository.findAllByPosition(position);
    }

    public Employee updateEmployee(String id, Employee updated) {
        Employee current = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (updated.getSalary() != null)
            current.setSalary(updated.getSalary());
        if (updated.getPosition() != null)
            current.setPosition(updated.getPosition());
        if (updated.getYearsOfExperience() != null)
            current.setYearsOfExperience(updated.getYearsOfExperience());

        return repository.save(current);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(String id) {
        repository.deleteById(id);
    }
}
