package com.example.winterland.controllers;

import com.example.winterland.entities.EmployeeEntity;
import com.example.winterland.repositories.EmployeeRepo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Endpoint 1: GET /api/employees/by-department-and-salary?department=...&minSalary=...
    @GetMapping("/by-department-and-salary")
    public ResponseEntity<List<EmployeeEntity>> getByDepartmentAndSalary(
            @RequestParam String department,
            @RequestParam Double minSalary) {
        List<EmployeeEntity> employees = employeeRepo
                .findByDepartmentAndSalaryGreaterThanOrderByHireDateDesc(department, minSalary);
        return ResponseEntity.ok(employees);
    }

    // Endpoint 2: GET /api/employees/top5-highest-paid?minAge=...&maxAge=...
    @GetMapping("/top5-highest-paid")
    public ResponseEntity<List<EmployeeEntity>> getTop5HighestPaid(
            @RequestParam Integer minAge,
            @RequestParam Integer maxAge) {
        List<EmployeeEntity> employees = employeeRepo
                .findTop5ActiveEmployeesByAgeBetweenOrderBySalaryDesc(minAge, maxAge);
        return ResponseEntity.ok(employees);
    }

    // Endpoint 3: GET /api/employees/count?department=...&position=...
    @GetMapping("/count")
    public ResponseEntity<Long> countByDepartmentAndPosition(
            @RequestParam String department,
            @RequestParam String position) {
        Long count = employeeRepo.countByDepartmentAndPosition(department, position);
        return ResponseEntity.ok(count);
    }

    // Endpoint 4: GET /api/employees/search?keyword=...&departments=...&startDate=...&endDate=...
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeEntity>> searchEmployees(
            @RequestParam String keyword,
            @RequestParam List<String> departments,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<EmployeeEntity> employees = employeeRepo
                .searchEmployees(keyword, departments, startDate, endDate);
        return ResponseEntity.ok(employees);
    }
}
