package org.example.vladsin.company.repository;

import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.entity.Employee;
import org.example.vladsin.company.exeption.UsernameNotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Employee findById(Long id);

    Employee findByEmail(String email);

    List<Employee> findAll();

    List<Employee> findAllByMarried(boolean married);

    List<Employee> findAllBySalaryAfter(double salary);

    List<Employee> findAllBySalaryBefore(double salary);

    List<Employee> findAllBySalaryBetween(double minSalary, double maxSalary);

    List<Employee> findAllByDepartment(Department department);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Employee set username = :username where id = :id")
    void updateUsername(@Param("id") Long id, @Param("username") String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Employee set password = :password where id = :id")
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Employee set email = :email where id = :id")
    void updateEmail(@Param("id") Long id, @Param("email") String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Employee set salary = :salary where id = :id")
    void updateSalary(@Param("id") Long id, @Param("salary") double salary);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Employee set married = :married where id = :id")
    void updateMarried(@Param("id") Long id, @Param("married") boolean married);

    void updateEmployeeData(Long id, Employee employee);

    void deleteById(Long id);
}
