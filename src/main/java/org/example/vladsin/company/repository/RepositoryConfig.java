package org.example.vladsin.company.repository;

import org.example.vladsin.company.config.HibernateConfig;
import org.example.vladsin.company.repository.impl.CompanyRepositoryImpl;
import org.example.vladsin.company.repository.impl.DepartmentRepositoryImpl;
import org.example.vladsin.company.repository.impl.EmployeeRepositoryImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
public class RepositoryConfig {

    private final SessionFactory sessionFactory;

    public RepositoryConfig(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Bean
    public CompanyRepository companyRepository() {
        return new CompanyRepositoryImpl(sessionFactory);
    }

    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentRepositoryImpl(sessionFactory);
    }

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepositoryImpl(sessionFactory);
    }
}
