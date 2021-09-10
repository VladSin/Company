package org.example.vladsin.company.repository.impl;

import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.repository.DepartmentRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public Department findByName(String name) {
        return null;
    }

    @Override
    public List<Department> findAllByLocation(String location) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public void updateName(Long id, String name) {

    }

    @Override
    public void updateWebsite(Long id, String website) {

    }

    @Override
    public void updateLocation(Long id, String location) {

    }

    @Override
    public void updateCompany(Long id, Company company) {

    }

    @Override
    public void updateDepartmentData(Long id, Department department) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
