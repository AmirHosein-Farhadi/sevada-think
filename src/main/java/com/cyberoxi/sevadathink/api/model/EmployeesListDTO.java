package com.cyberoxi.sevadathink.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeesListDTO {

    private List<EmployeeDTO> employees;

}
