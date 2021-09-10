package org.example.vladsin.company.service;

import org.example.vladsin.company.entity.Company;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    Company getCompanyById(Long id);

    Company getCompanyByName(String name);

    List<Company> getAllCompanyByLocation(String location);

    List<Company> getAllCompany();

    void updateCompanyName(Long id, String name);

    void updateCompanyWebsite(Long id, String website);

    void updateCompanyLocation(Long id, String location);

    void updateCompanyBudget(Long id, double budget);

    void updateCompanyData(Long id, Company company);

    void deleteCompany(Long id);

    boolean uniqueName(String name);
}
