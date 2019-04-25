package com.cyberoxi.sevadathink.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = "projects", callSuper = false)
@Entity
public class Employee extends AuditModel {

    private String avatar;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @Lob
    private String address;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    //@ManyToMany(mappedBy = "employees")   dont need this if we got only 1 company
    @ManyToOne
    private Company company;
}
