package com.example.winterland.repositories;

import com.example.winterland.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    // Query 1: Find by department with salary > minSalary, sorted by hireDate DESC
    @Query("SELECT e FROM EmployeeEntity e WHERE e.department = :department AND e.salary > :minSalary ORDER BY e.hireDate DESC")
    List<EmployeeEntity> findByDepartmentAndSalaryGreaterThanOrderByHireDateDesc(
            @Param("department") String department,
            @Param("minSalary") Double minSalary);

    // Query 2: Top 5 active employees by age range, sorted by salary DESC
    @Query("SELECT e FROM EmployeeEntity e WHERE e.isActive = true AND e.age >= :minAge AND e.age <= :maxAge ORDER BY e.salary DESC LIMIT 5")
    List<EmployeeEntity> findTop5ActiveEmployeesByAgeBetweenOrderBySalaryDesc(
            @Param("minAge") Integer minAge,
            @Param("maxAge") Integer maxAge);

    // Query 3: Count by department and position
    @Query("SELECT COUNT(e) FROM EmployeeEntity e WHERE e.department = :department AND e.position = :position")
    Long countByDepartmentAndPosition(
            @Param("department") String department,
            @Param("position") String position);

    // Query 4: Search by keyword (case-insensitive), department list, and date range
    @Query("SELECT e FROM EmployeeEntity e WHERE (LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND e.department IN :departments AND e.hireDate >= :startDate AND e.hireDate <= :endDate ORDER BY e.hireDate DESC")
    List<EmployeeEntity> searchEmployees(
            @Param("keyword") String keyword,
            @Param("departments") List<String> departments,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Query 5: Find active employees hired after a date, sorted by hireDate ASC
    @Query("SELECT e FROM EmployeeEntity e WHERE e.isActive = true AND e.hireDate > :date ORDER BY e.hireDate ASC")
    List<EmployeeEntity> findActiveEmployeesHiredAfter(@Param("date") LocalDate date);
}
