package com.cyberoxi.sevadathink.controller;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.model.Employee;
import com.cyberoxi.sevadathink.model.Project;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import com.cyberoxi.sevadathink.repositories.EmployeeRepository;
import com.cyberoxi.sevadathink.repositories.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public AdminController(CompanyRepository companyRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/companies")
    public List<Company> allCompanies(){
        return companyRepository.findAll();
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/projects")
    public List<Project> allProjects(){
        return projectRepository.findAll();
    }

}
