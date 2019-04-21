package com.cyberoxi.sevadathink.controller;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/new")
    public void newCompany(@RequestBody Company company){
        companyRepository.save(company);
    }

    @GetMapping("/{id}")
    public Company companyDetail(@PathVariable("id") String id){
        //todo exception
        return companyRepository.findById(Long.valueOf(id)).get();
    }
}
