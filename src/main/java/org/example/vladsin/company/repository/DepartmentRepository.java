package org.example.vladsin.company.repository;

import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.entity.Department;

import java.util.List;

public interface DepartmentRepository {

    Department save(Department department);

    Department findById(Long id);

    Department findByName(String name);

    List<Department> findAllByLocation(String location);

    List<Department> findAll();

    void updateName(Long id, String name);

    void updateWebsite(Long id, String website);

    void updateLocation(Long id, String location);

    void updateCompany(Long id, Company company);

    void updateDepartmentData(Long id, Department department);

    void deleteById(Long id);
}
