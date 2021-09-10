package org.example.vladsin.company.service.impl;

import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.repository.DepartmentRepository;
import org.example.vladsin.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Department> getAllDepartmentByLocation(String location) {
        return departmentRepository.findAllByLocation(location);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void updateDepartmentName(Long id, String name) {
        departmentRepository.updateName(id, name);
    }

    @Override
    public void updateDepartmentWebsite(Long id, String website) {
        departmentRepository.updateWebsite(id, website);
    }

    @Override
    public void updateDepartmentLocation(Long id, String location) {
        departmentRepository.updateLocation(id, location);
    }

    @Override
    public void updateDepartmentCompany(Long id, Company company) {
        departmentRepository.updateCompany(id, company);
    }

    @Override
    public void updateDepartmentData(Long id, Department department) {
        departmentRepository.updateDepartmentData(id, department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public boolean uniqueName(String name) {
        return departmentRepository.findByName(name) == null;
    }
}
