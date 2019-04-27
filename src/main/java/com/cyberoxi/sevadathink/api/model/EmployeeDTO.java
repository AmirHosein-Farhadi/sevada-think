package com.cyberoxi.sevadathink.api.model;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long id;

    private boolean verified = true;

    private String avatar;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private CompanyDTO company;
}
