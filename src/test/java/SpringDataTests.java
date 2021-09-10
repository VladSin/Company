import org.example.vladsin.company.entity.Company;
import org.example.vladsin.company.entity.Department;
import org.example.vladsin.company.entity.Employee;
import org.example.vladsin.company.repository.CompanyRepository;
import org.example.vladsin.company.repository.DepartmentRepository;
import org.example.vladsin.company.repository.EmployeeRepository;
import org.example.vladsin.company.repository.RepositoryConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RepositoryConfig.class)
@Transactional
@Commit
class SpringDataTests {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

//    @BeforeEach
//    public void init() {
//
//        Company itCompany = new Company(null, "ITCompany", "http://company.com", "Minsk", 10000000, null);
//
//        Department qa = new Department(null, "CompanyQA", "http://companyQA.com", "Minsk", itCompany, null);
//        Department ba = new Department(null, "CompanyBA", "http://companyBA.com", "Minsk", itCompany, null);
//        Department hr = new Department(null, "CompanyHR", "http://companyHR.com", "Brest", itCompany, null);
//        Department pm = new Department(null, "CompanyPM", "http://companyPM.com", "Brest", itCompany, null);
//        Department al = new Department(null, "CompanyAL", "http://companyAL.com", "Minsk", itCompany, null);
//
//        Employee employee1 = new Employee(null, "Vasy", "123", "Vasy@gmail.com", 500, true,  qa);
//        Employee employee2 = new Employee(null, "Vany", "123", "Vany@gmail.com", 400, false, qa);
//        Employee employee3 = new Employee(null, "Zina", "123", "Zina@gmail.com", 400, false, qa);
//        Employee employee4 = new Employee(null, "Yana", "123", "Yana@gmail.com", 800, false, hr);
//        Employee employee5 = new Employee(null, "Kate", "123", "Kate@gmail.com", 300, true,  hr);
//        Employee employee6 = new Employee(null, "Gena", "123", "Gena@gmail.com", 700, true,  ba);
//        Employee employee7 = new Employee(null, "Pety", "123", "Pety@gmail.com", 900, true,  pm);
//        Employee employee8 = new Employee(null, "Alex", "123", "Alex@gmail.com", 500, false, al);
//
//        List<Employee> employeesQA = new ArrayList<>();
//        List<Employee> employeesHR = new ArrayList<>();
//        List<Employee> employeesBA = new ArrayList<>();
//        List<Employee> employeesPM = new ArrayList<>();
//        List<Employee> employeesAL = new ArrayList<>();
//
//        employeesAL.add(employee8); al.setEmployees(employeesAL);
//        employeesPM.add(employee7); al.setEmployees(employeesPM);
//        employeesBA.add(employee6); al.setEmployees(employeesBA);
//        employeesHR.add(employee4); employeesHR.add(employee5); al.setEmployees(employeesHR);
//        employeesQA.add(employee1); employeesQA.add(employee2); employeesQA.add(employee3); al.setEmployees(employeesQA);
//
//        List<Department> departments = new ArrayList<>();
//        departments.add(qa);
//        departments.add(al);
//        departments.add(hr);
//        departments.add(ba);
//        departments.add(pm);
//
//        itCompany.setDepartments(departments);
//
//        companyRepository.save(itCompany);
//
//        departmentRepository.save(qa);
//        departmentRepository.save(ba);
//        departmentRepository.save(hr);
//        departmentRepository.save(pm);
//        departmentRepository.save(al);
//
//        employeeRepository.save(employee1);
//        employeeRepository.save(employee2);
//        employeeRepository.save(employee3);
//        employeeRepository.save(employee4);
//        employeeRepository.save(employee5);
//        employeeRepository.save(employee6);
//        employeeRepository.save(employee7);
//        employeeRepository.save(employee8);
//    }

    @Test
    void SaveEmployee() {
        final  Employee employeeToSave = new Employee(null, "Rita", "123", "Rita@gmail.com", 500, true,  null);
        final  Employee savedEmployee = employeeRepository.save(employeeToSave);

        assertNotNull(savedEmployee);
        assertEquals(employeeToSave.getUsername(), savedEmployee.getUsername());
        assertEquals(employeeToSave.getPassword(), savedEmployee.getPassword());
        assertEquals(employeeToSave.getEmail(), savedEmployee.getEmail());
    }

    @Test
    void getEmployeeByEmail() {
        Employee employee = new Employee(null, "Fedy", "123", "Fedy@gmail.com", 500, true,  null);
        employeeRepository.save(employee);
        final  Employee savedEmployee = employeeRepository.findByEmail("Fedy@gmail.com");
        assertNotNull(savedEmployee);
    }

    @Test
    void getAllEmployee() {
        Employee employee1 = new Employee(null, "Vasy", "123", "Vasy@gmail.com", 500, true,  null);
        Employee employee2 = new Employee(null, "Vany", "123", "Vany@gmail.com", 400, false, null);
        Employee employee3 = new Employee(null, "Zina", "123", "Zina@gmail.com", 400, false, null);
        Employee employee4 = new Employee(null, "Yana", "123", "Yana@gmail.com", 800, false, null);
        Employee employee5 = new Employee(null, "Kate", "123", "Kate@gmail.com", 300, true,  null);
        Employee employee6 = new Employee(null, "Gena", "123", "Gena@gmail.com", 700, true,  null);
        Employee employee7 = new Employee(null, "Pety", "123", "Pety@gmail.com", 900, true,  null);
        Employee employee8 = new Employee(null, "Alex", "123", "Alex@gmail.com", 500, false, null);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);
        employeeRepository.save(employee7);
        employeeRepository.save(employee8);

        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
    }

    @Test
    void updateEmployeeEmail() {
        Employee employee = new Employee(null, "Vova", "123", "Vova@gmail.com", 500, true,  null);
        employeeRepository.save(employee);

        Employee savedEmployee = employeeRepository.findByEmail("Vova@gmail.com");
        employeeRepository.updateEmail(savedEmployee.getId(),"Vovan@gmail.com");

        Employee updateEmployee = employeeRepository.findById(savedEmployee.getId());
        assertEquals("Vovan@gmail.com", updateEmployee.getEmail());
    }
}