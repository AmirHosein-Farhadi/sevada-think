package com.cyberoxi.sevadathink.api.services;

import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.api.model.EmployeesListDTO;
import com.cyberoxi.sevadathink.api.model.ProjectsListDTO;

public interface CompanyService {
    CompanyDTO getCompany();

    EmployeesListDTO getEmployees();

    ProjectsListDTO getProjects();
}
