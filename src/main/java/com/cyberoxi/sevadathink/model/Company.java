package com.cyberoxi.sevadathink.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"employees", "projects"}, callSuper = false)
@Entity
public class Company extends AuditModel {

    private String Logo;

    private String name;

    private String email;

    @Lob
    private String address;

    private String phoneNumber;

    private String priceUnit;

    private String startOfTheWeek;

    private String comments;

//    @JoinTable(name = "company_employees",
//            joinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "employees_id", referencedColumnName = "id"))
    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    @OneToMany
    private List<Project> projects = new ArrayList<>();

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
