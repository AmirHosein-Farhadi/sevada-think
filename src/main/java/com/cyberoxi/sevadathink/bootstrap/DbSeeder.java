package com.cyberoxi.sevadathink.bootstrap;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.model.Employee;
import com.cyberoxi.sevadathink.model.Project;
import com.cyberoxi.sevadathink.model.User;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import com.cyberoxi.sevadathink.repositories.EmployeeRepository;
import com.cyberoxi.sevadathink.repositories.ProjectRepository;
import com.cyberoxi.sevadathink.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DbSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public DbSeeder(EmployeeRepository employeeRepository, CompanyRepository companyRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
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
        User user1 = new User();


        Project project = new Project();
        Project project1 = new Project();

        employee.setFirstName("Amir");
        employee.setEmail("cnooed@gmail.com");
        employee.setCompany(company);
        employee.addProject(project);
        employee.addProject(project1);

        company.setAddress("ffwegerhethertjherhergerwfgwe");
        company.setName("CyberOxi");
        company.addEmployee(employee);
        company.addEmployee(employee1);
        company.addProject(project);
        company.addProject(project1);

        project.setCompany(company);
        project.setBudget("4444444444");
        project.addEmployee(employee);
        project.addEmployee(employee1);
        project.setOwner(user);

        employee1.setFirstName("Mohammad");
        employee1.setEmail("mmk@gmail.com");
        employee1.setCompany(company);
        employee1.addProject(project1);
        employee1.addProject(project);

        project1.setCompany(company);
        project1.setBudget("555555555");
        project1.addEmployee(employee);
        project1.addEmployee(employee1);
        project1.setOwner(user1);

        user1.setFirstName("user1");
        user1.setPassword("password");
        user1.setUsername("user1");
        user1.setPhoneNumber("1111111111");
        user1.addPoject(project1);

        user.setFirstName("user");
        user.setPassword("password");
        user.setUsername("user");
        user.setPhoneNumber("555555555");
        user.addPoject(project);

        employeeRepository.save(employee);
        projectRepository.save(project);
        userRepository.save(user);
        userRepository.save(user1);
        employeeRepository.save(employee1);
        projectRepository.save(project1);
        companyRepository.save(company);
    }

}
