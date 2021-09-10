package org.example.vladsin.company.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.entity.Employee;
import org.example.vladsin.company.repository.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee save(Employee employee) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        log.info("employee saved:{}", employee);
        return employee;
    }

    @Override
    public Employee findById(Long id) {
        Employee employee;
        try {
            employee = (Employee) sessionFactory.getCurrentSession()
                    .createQuery("from Employee e where e.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            log.info("get employee:{}", employee);
        } catch (NoResultException e) {
            log.info("user not found by id{}", id);
            employee = null;
        }
        return employee;
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employee;
        try {
            employee = (Employee) sessionFactory.getCurrentSession()
                    .createQuery("from Employee e where e.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
            log.info("get employee:{}", employee);
        } catch (NoResultException e) {
            log.info("user not found by email{}", email);
            employee = null;
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) sessionFactory
                .getCurrentSession()
                .createQuery("from Employee")
                .list();
    }

    @Override
    public List<Employee> findAllByMarried(boolean married) {
        return (List<Employee>) sessionFactory
                .getCurrentSession()
                .createQuery("from Employee where married = :married")
                .list();
    }

    @Override
    public List<Employee> findAllBySalaryAfter(double salary) {
        return (List<Employee>) sessionFactory
                .getCurrentSession()
                .createQuery("from Employee where salary >= :salary")
                .list();
    }

    @Override
    public List<Employee> findAllBySalaryBefore(double salary) {
        return (List<Employee>) sessionFactory
                .getCurrentSession()
                .createQuery("from Employee where salary <= :salary")
                .list();
    }

    @Override
    public List<Employee> findAllBySalaryBetween(double minSalary, double maxSalary) {
        return (List<Employee>) sessionFactory
                .getCurrentSession()
                .createQuery("from Employee where salary <= :salary and salary >= :salary")
                .list();
    }

    @Override
    public List<Employee> findAllByDepartment(Department department) {

        final Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> entityRoot = criteria.from(Employee.class);
        Predicate predicate = cb.and(cb.equal(entityRoot.get("department"), department));
        criteria.select(entityRoot).where(predicate);

        return session.createQuery(criteria).getResultList();
    }

    @Override
    public void updateUsername(Long id, String username) {

    }

    @Override
    public void updatePassword(Long id, String password) {

    }

    @Override
    public void updateEmail(Long id, String email) {

    }

    @Override
    public void updateSalary(Long id, double salary) {

    }

    @Override
    public void updateMarried(Long id, boolean married) {

    }

    @Override
    public void updateEmployeeData(Long id, Employee employee) {
        final Session session = sessionFactory.getCurrentSession();
        session.update(employee);
        log.info("employee updated:{}", employee);

    }

    @Override
    public void deleteById(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Employee as a where a.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        log.info("user deleted:{}", id);
    }
}
