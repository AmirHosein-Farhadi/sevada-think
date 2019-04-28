package com.cyberoxi.sevadathink.controller;

import com.cyberoxi.sevadathink.model.Company;
import com.cyberoxi.sevadathink.repositories.CompanyRepository;
import com.cyberoxi.sevadathink.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CompanyService companyService;

    public CompanyController(CompanyRepository companyRepository, CompanyService companyService) {
        this.companyRepository = companyRepository;
        this.companyService = companyService;
    }

    @PostMapping("/new")
    public void newCompany(@RequestBody Company company){
        companyRepository.save(company);
    }

    @PutMapping("/update")
    public ResponseEntity updateCompany(@RequestBody Company company){
        companyRepository.save(companyService.updateCompany(company));
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> companyDetail() {

        Map<String, Object> respond = new HashMap<>();

        respond.put("company", companyService.getCompany());
        respond.put("employees", companyService.getEmployees().getEmployees());
        respond.put("projects", companyService.getProjects().getProjects());

        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
