package org.example.vladsin.company.repository;

import org.example.vladsin.company.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    Company save(Company company);

    Company findById(Long id);

    Company findByName(String name);

    List<Company> findAllByLocation(String location);

    List<Company> findAll();

    void updateName(Long id, String name);

    void updateWebsite(Long id, String website);

    void updateLocation(Long id, String location);

    void updateBudget(Long id, double budget);

    void updateCompanyData(Long id, Company company);

    void deleteById(Long id);
}
