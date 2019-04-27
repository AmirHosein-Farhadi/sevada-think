package com.cyberoxi.sevadathink.bootstrap;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.model.Employee;
import com.cyberoxi.sevadathink.model.Project;
import com.cyberoxi.sevadathink.model.User;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import com.cyberoxi.sevadathink.repositories.EmployeeRepository;
import com.cyberoxi.sevadathink.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DbSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final ProjectRepository projectRepository;

    public DbSeeder(EmployeeRepository employeeRepository, CompanyRepository companyRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData(){

        Employee employee = new Employee();
        Employee employee1 = new Employee();

        Company company = new Company();

        User user = new User();
        user.setFirstName("user");
        user.setPassword("password");
        user.setUsername("user");
        user.setPhoneNumber("555555555");

        Project project = new Project();
        Project project1 = new Project();

        employee.setFirstName("Amir");
        employee.setEmail("cnooed@gmail.com");
        employee.setCompany(company);
        employee.addProject(project);

        company.setAddress("ffwegerhethertjherhergerwfgwe");
        company.setName("CyberOxi");
        company.addEmployee(employee);
        company.addEmployee(employee1);
        company.addProject(project);

        project.setCompany(company);
        project.setBudget("4444444444");
        project.addEmployee(employee);


        employee1.setFirstName("Mohammad");
        employee1.setEmail("mmk@gmail.com");
        employee1.setCompany(company);
        employee1.addProject(project1);

        project1.setOwner(company);
        project1.setBudget("555555555");
        project1.addEmployee(employee1);

        employeeRepository.save(employee);
        projectRepository.save(project);

        employeeRepository.save(employee1);
        projectRepository.save(project1);
        companyRepository.save(company);
    }

}
