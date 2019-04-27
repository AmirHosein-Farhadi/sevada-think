package com.cyberoxi.sevadathink.repositories;

import com.cyberoxi.sevadathink.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByName(String name);
    List<Company> findAll();
}
