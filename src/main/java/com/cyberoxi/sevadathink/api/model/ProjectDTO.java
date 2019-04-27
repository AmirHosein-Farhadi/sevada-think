package com.cyberoxi.sevadathink.api.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProjectDTO {

    private Long id;

    private boolean verified = true;

    private String title;

    private String projectToken;

    private String description;

    private String location;

    private Date startDate;

    private Date finishDate;

    private String budget;

    private List<String> platforms = new ArrayList<>();

    private int priority;

    private CompanyDTO owner;
}
