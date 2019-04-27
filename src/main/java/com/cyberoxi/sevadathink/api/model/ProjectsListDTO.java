package com.cyberoxi.sevadathink.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectsListDTO {

    private List<ProjectDTO> projects;

}
