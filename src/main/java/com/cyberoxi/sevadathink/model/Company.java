package com.cyberoxi.sevadathink.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"employees", "projects"}, callSuper = true)
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
