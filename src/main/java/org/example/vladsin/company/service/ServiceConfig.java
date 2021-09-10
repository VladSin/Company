package org.example.vladsin.company.service;


import org.example.vladsin.company.repository.RepositoryConfig;
import org.example.vladsin.company.service.impl.CompanyServiceImpl;
import org.example.vladsin.company.service.impl.DepartmentServiceImpl;
import org.example.vladsin.company.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private RepositoryConfig repositoryConfig;

    public ServiceConfig(RepositoryConfig repositoryConfig) {
        this.repositoryConfig = repositoryConfig;
    }

    @Bean
    public CompanyService companyService() {
        return new CompanyServiceImpl(repositoryConfig.companyRepository());
    }

    @Bean
    public DepartmentService departmentService() {
        return new DepartmentServiceImpl(repositoryConfig.departmentRepository());
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl(repositoryConfig.employeeRepository());
    }
}
