package org.example.vladsin.company.service.impl;

import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.entity.Employee;
import org.example.vladsin.company.exeption.UsernameNotFoundException;
import org.example.vladsin.company.repository.EmployeeRepository;
import org.example.vladsin.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllByMarried(boolean married) {
        return employeeRepository.findAllByMarried(married);
    }

    @Override
    public List<Employee> getAllBySalaryAfter(double salary) {
        return employeeRepository.findAllBySalaryAfter(salary);
    }

    @Override
    public List<Employee> getAllBySalaryBefore(double salary) {
        return employeeRepository.findAllBySalaryBefore(salary);
    }

    @Override
    public List<Employee> getAllBySalaryBetween(double minSalary, double maxSalary) {
        return employeeRepository.findAllBySalaryBetween(minSalary, maxSalary);
    }

    @Override
    public List<Employee> getAllByDepartment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }

    @Override
    public void updateUsername(Long id, String username) {
        employeeRepository.updateUsername(id, username);
    }

    @Override
    public void updateEmployeePassword(Long id, String password) {
        employeeRepository.updatePassword(id, password);
    }

    @Override
    public void updateEmployeeEmail(Long id, String email) {
        employeeRepository.updateEmail(id, email);
    }

    @Override
    public void updateSalary(Long id, double salary) {
        employeeRepository.updateSalary(id, salary);
    }

    @Override
    public void updateMarried(Long id, boolean married) {
        employeeRepository.updateMarried(id, married);
    }

    @Override
    public void updateEmployeeData(Long id, Employee employee) {
        employeeRepository.updateEmployeeData(id, employee);
    }

    @Override
    public boolean checkEmail(String email) throws UsernameNotFoundException {
        Employee user = employeeRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email: " + email + " not found");
        }
        return true;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
