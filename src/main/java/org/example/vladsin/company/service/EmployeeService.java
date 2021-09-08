package org.example.vladsin.company.service;

import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.entity.Employee;
import org.example.vladsin.company.exeption.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Long id);

    Employee getEmployeeByEmail(String email);

    List<Employee> getAll();

    List<Employee> getAllByMarried(boolean married);

    List<Employee> getAllBySalaryAfter(double salary);

    List<Employee> getAllBySalaryBefore(double salary);

    List<Employee> getAllBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> getAllByDepartment(Department department);

    void updateUsername(Long id, String username);

    void updateEmployeePassword(Long id, String password);

    void updateEmployeeEmail(Long id, String email);

    void updateSalary(Long id, double salary);

    void updateMarried(Long id, boolean married);

    void updateEmployeeData(Long id, Employee employee);

    boolean checkEmail(String email) throws UsernameNotFoundException;

    void deleteEmployee(Long id);
}
