package com.cyberoxi.sevadathink.api.mapper;

import com.cyberoxi.sevadathink.api.model.CompanyDTO;
import com.cyberoxi.sevadathink.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO companyToCompanyDTO(Company company);
}
