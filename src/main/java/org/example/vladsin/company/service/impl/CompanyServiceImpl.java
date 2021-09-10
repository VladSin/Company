package org.example.vladsin.company.service.impl;

import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.repository.CompanyRepository;
import org.example.vladsin.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public List<Company> getAllCompanyByLocation(String location) {
        return companyRepository.findAllByLocation(location);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void updateCompanyName(Long id, String name) {
        companyRepository.updateName(id, name);
    }

    @Override
    public void updateCompanyWebsite(Long id, String website) {
        companyRepository.updateWebsite(id, website);
    }

    @Override
    public void updateCompanyLocation(Long id, String location) {
        companyRepository.updateLocation(id, location);
    }

    @Override
    public void updateCompanyBudget(Long id, double budget) {
        companyRepository.updateBudget(id, budget);
    }

    @Override
    public void updateCompanyData(Long id, Company company) {
        companyRepository.updateCompanyData(id, company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public boolean uniqueName(String name) {
        return companyRepository.findByName(name) == null;
    }
}
