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

        Company company = new Company();

        Project project = new Project();

        employee.setFirstName("Amir");
        employee.setEmail("cnooed@gmail.com");
        employeeRepository.save(employee);


        company.setAddress("ffwegerhethertjherhergerwfgwe");
        company.setName("gggggggggg");
        companyRepository.save(company);


        project.setOwner(company);
        project.setBudget("4444444444");
        projectRepository.save(project);


    }

}
