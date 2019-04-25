package com.cyberoxi.sevadathink.bootstrap;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.model.Employee;
import com.cyberoxi.sevadathink.model.Project;
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
        Company company1 = new Company();

        Project project = new Project();
        Project project1 = new Project();

        employee.setFirstName("Amir");
        employee.setEmail("cnooed@gmail.com");
        employee.setCompany(company);
        employee.addProject(project);

        company.setAddress("ffwegerhethertjherhergerwfgwe");
        company.setName("gggggggggg");
        company.addEmployee(employee);
        company.addProject(project);

        project.setOwner(company);
        project.setBudget("4444444444");
        project.addEmployee(employee);


        employee1.setFirstName("mohammad");
        employee1.setEmail("mmk@gmail.com");
        employee1.setCompany(company1);
        employee1.addProject(project1);

        company1.setAddress("wfeewfwefewgreger");
        company1.setName("wefewfwefdfff");
        company1.addEmployee(employee1);
        company1.addProject(project1);

        project1.setOwner(company1);
        project1.setBudget("555555555");
        project1.addEmployee(employee1);

        companyRepository.save(company);
        employeeRepository.save(employee);
        projectRepository.save(project);

        companyRepository.save(company1);
        employeeRepository.save(employee1);
        projectRepository.save(project1);
    }

}
