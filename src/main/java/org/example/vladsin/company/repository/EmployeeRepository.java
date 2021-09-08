package org.example.vladsin.company.repository;

import org.example.vladsin.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
