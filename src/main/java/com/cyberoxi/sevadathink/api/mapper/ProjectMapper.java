package com.cyberoxi.sevadathink.api.mapper;

import com.cyberoxi.sevadathink.api.model.ProjectDTO;
import com.cyberoxi.sevadathink.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDTO projectToProjectDTO(Project project);

    Project projectDTOtoProject(ProjectDTO projectDTO);
}
