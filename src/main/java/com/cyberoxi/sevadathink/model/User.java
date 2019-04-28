package com.cyberoxi.sevadathink.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = "projects", callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends AuditModel {
    @NotBlank
    @NotNull
    @Column(unique = true)
    @Size(min = 8, max = 20)
    private String phoneNumber;         //this is the field which should be unique and identifies the user

    @Column(unique = true)
    @Size(min = 4, max = 20)
    private String username;            //or we can switch to user name
    //todo Decide Which one to implement

    @Column(length = 100)
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private List<Role> roles;

    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive = true;
    private String address;

    @OneToMany
    private List<Project> projects = new ArrayList<>();

    public void addPoject(Project project){
        this.projects.add(project);
    }
}
