package com.cyberoxi.sevadathink.services;

import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.api.model.EmployeesListDTO;
import com.cyberoxi.sevadathink.api.model.ProjectsListDTO;

public interface CompanyService {

    CompanyDTO getCompany();

    EmployeesListDTO getEmployees();

    ProjectsListDTO getProjects();

    CompanyDTO updateCompany(CompanyDTO companyDTO);

    CompanyDTO patchCompany(CompanyDTO companyDTO);

    void updateEmployees(EmployeesListDTO employeesListDTO);

    void updateProjects(ProjectsListDTO projectsListDTO);

    void deleteCompany(Long id);
}
