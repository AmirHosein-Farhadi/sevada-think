package com.cyberoxi.sevadathink.repositories;

import com.cyberoxi.sevadathink.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
