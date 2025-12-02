package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.service.EmployeesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeesService service;

    public EmployeesController(EmployeesService service) {
        this.service = service;
    }

    // 1. GET employees by position
    @GetMapping
    public List<Employee> getAllByPosition(@RequestParam String position) {
        return service.getAllEmployeesByPosition(position);
    }

    // 2. PATCH update employee by id
    @PatchMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable String id,
            @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // 3. POST add employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // 4. DELETE by query parameter
    @DeleteMapping
    public String deleteEmployee(@RequestParam String id) {
        service.deleteEmployee(id);
        return "Employee deleted";
    }
}
