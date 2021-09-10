package org.example.vladsin.company.repository.impl;

import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.repository.CompanyRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public Company findById(Long id) {
        return null;
    }

    @Override
    public Company findByName(String name) {
        return null;
    }

    @Override
    public List<Company> findAllByLocation(String location) {
        return null;
    }

    @Override
    public List<Company> findAll() {
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
    public void updateBudget(Long id, double budget) {

    }

    @Override
    public void updateCompanyData(Long id, Company company) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
