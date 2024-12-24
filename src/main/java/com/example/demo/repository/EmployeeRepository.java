package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmailId(String emailId);
}
