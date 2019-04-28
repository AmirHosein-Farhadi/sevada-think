package com.cyberoxi.sevadathink.services;

import com.cyberoxi.sevadathink.api.mapper.CompanyMapper;
import com.cyberoxi.sevadathink.api.mapper.EmployeeMapper;
import com.cyberoxi.sevadathink.api.mapper.ProjectMapper;
import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.api.model.EmployeesListDTO;
import com.cyberoxi.sevadathink.api.model.ProjectsListDTO;
import com.cyberoxi.sevadathink.exceptions.ResourceNotFoundException;
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

    private static final String COMPANY_NAME = "CyberOxi";

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper, ProjectMapper projectMapper, EmployeeMapper employeeMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
        this.projectMapper = projectMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public CompanyDTO getCompany() {
        return companyMapper.companyToCompanyDTO(companyRepository.findByName(COMPANY_NAME).get());     //todo we can check for exception
    }

    @Override
    public EmployeesListDTO getEmployees() {
        return new EmployeesListDTO(companyRepository.findByName(COMPANY_NAME).get()
                .getEmployees()
                .stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList())
        );
    }

    @Override
    public ProjectsListDTO getProjects() {
        return new ProjectsListDTO(companyRepository.findByName(COMPANY_NAME).get()
                .getProjects()
                .stream()
                .map(projectMapper::projectToProjectDTO)
                .collect(Collectors.toList())
        );
    }

    @Override
    public CompanyDTO patchCompany(CompanyDTO companyDTO) {
        Company companyOld = companyRepository.findByName(COMPANY_NAME).get();

        return companyRepository.findByName(COMPANY_NAME).map(company -> {

            if (companyDTO.getLogo() != null)
                company.setLogo(companyDTO.getLogo());

            if (companyDTO.getName() != null)
                company.setName(companyDTO.getName());

            if (companyDTO.getEmail() != null)
                company.setEmail(companyDTO.getEmail());

            if (companyDTO.getAddress() != null)
                company.setAddress(companyDTO.getAddress());

            if (companyDTO.getPhoneNumber() != null)
                company.setPhoneNumber(companyDTO.getPhoneNumber());

            if (companyDTO.getPriceUnit() != null)
                company.setPriceUnit(companyDTO.getPriceUnit());

            if (companyDTO.getStartOfTheWeek() != null)
                company.setStartOfTheWeek(companyDTO.getStartOfTheWeek());

            if (companyDTO.getComments() != null)
                company.setComments(companyDTO.getComments());

            company.setEmployees(companyOld.getEmployees());
            company.setProjects(companyOld.getProjects());

            return companyMapper.companyToCompanyDTO(companyRepository.save(company));

        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void updateEmployees(EmployeesListDTO employeesListDTO) {
        companyRepository.findByName(COMPANY_NAME).get().setEmployees(
        employeesListDTO
                .getEmployees()
                .stream()
                .map(employeeMapper::employeeDTOToEmployee)
                .collect(Collectors.toList())
        );
    }

    @Override
    public void updateProjects(ProjectsListDTO projectsListDTO) {
        companyRepository.findByName(COMPANY_NAME).get().setProjects(
        projectsListDTO
                .getProjects()
                .stream()
                .map(projectMapper::projectDTOtoProject)
                .collect(Collectors.toList())
        );
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        return saveAndReturnDTO(companyMapper.companyDTOToCompany(companyDTO));
    }

    private CompanyDTO saveAndReturnDTO(Company company) {
        return companyMapper.companyToCompanyDTO(companyRepository.save(company));
    }
}
