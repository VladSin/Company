package org.example.vladsin.company.service;


import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Optional<Department> getDepartmentById(Long id);

    Department getDepartmentByName(String name);

    List<Department> getAllDepartmentByLocation(String location);

    List<Department> getAllDepartment();

    void updateDepartmentName(Long id, String name);

    void updateDepartmentWebsite(Long id, String website);

    void updateDepartmentLocation(Long id, String location);

    void updateDepartmentCompany(Long id, Company company);

    void updateDepartmentData(Long id, Department department);

    void deleteDepartment(Long id);

    boolean uniqueName(String name);
}
