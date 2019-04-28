package com.cyberoxi.sevadathink.services;

import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.api.model.EmployeesListDTO;
import com.cyberoxi.sevadathink.api.model.ProjectsListDTO;
import com.cyberoxi.sevadathink.model.Company;

public interface CompanyService {
    CompanyDTO getCompany();

    EmployeesListDTO getEmployees();

    ProjectsListDTO getProjects();

    Company update(Company company);
}
