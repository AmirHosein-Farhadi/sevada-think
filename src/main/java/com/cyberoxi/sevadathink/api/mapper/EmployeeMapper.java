package com.cyberoxi.sevadathink.api.mapper;

import com.cyberoxi.sevadathink.api.model.EmployeeDTO;
import com.cyberoxi.sevadathink.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
