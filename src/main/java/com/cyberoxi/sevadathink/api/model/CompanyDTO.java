package com.cyberoxi.sevadathink.api.model;

import lombok.Data;

@Data
public class CompanyDTO {

    private Long id;

    private boolean verified = true;

    private String Logo;

    private String name;

    private String email;

    private String address;

    private String phoneNumber;

    private String priceUnit;

    private String startOfTheWeek;

    private String comments;
}
