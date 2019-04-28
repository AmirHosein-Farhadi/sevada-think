package com.cyberoxi.sevadathink.api.services;

import com.cyberoxi.sevadathink.api.mapper.CompanyMapper;
import com.cyberoxi.sevadathink.api.mapper.EmployeeMapper;
import com.cyberoxi.sevadathink.api.mapper.ProjectMapper;
import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.api.model.EmployeesListDTO;
import com.cyberoxi.sevadathink.api.model.ProjectsListDTO;
import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final ProjectMapper projectMapper;
    private final EmployeeMapper employeeMapper;

    private static final String companyName = "CyberOxi";

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper, ProjectMapper projectMapper, EmployeeMapper employeeMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.projectMapper = projectMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CompanyDTO getCompany() {
        return companyMapper.companyToCompanyDTO(companyRepository.findByName(companyName));     //todo we can check for exception
    }

    @Override
    public EmployeesListDTO getEmployees() {
        return new EmployeesListDTO(companyRepository.findByName(companyName).getEmployees()
                .stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList())
        );
    }

    @Override
    public ProjectsListDTO getProjects() {
        return new ProjectsListDTO(companyRepository.findByName(companyName).getProjects()
                .stream()
                .map(projectMapper::projectToProjectDTO)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Company update(Company company) {
        if (company.getProjects() == null)
            company.setProjects(companyRepository.findByName(companyName).getProjects());
        if (company.getEmployees() == null)
            company.setEmployees(companyRepository.findByName(companyName).getEmployees());
        return company;
    }
}
