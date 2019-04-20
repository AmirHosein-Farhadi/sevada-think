package com.cyberoxi.sevadathink.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = "employees", callSuper = false)
@Entity
public class Project extends AuditModel {

    private String title;

    private String projectToken;

    private String description;

    private String location;

    private Date startDate;

    private Date finishDate;

    private String budget;

    @ElementCollection
    private List<String> platforms = new ArrayList<>();

    private int priority;

    @ManyToOne
    private Company owner;

    @ManyToMany
    @JoinTable(name = "project_employees",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id", referencedColumnName = "id"))
    private List<Employee> employees = new ArrayList<>();
}
