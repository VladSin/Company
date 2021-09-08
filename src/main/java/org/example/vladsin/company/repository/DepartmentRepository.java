package org.example.vladsin.company.repository;

import org.example.vladsin.company.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
