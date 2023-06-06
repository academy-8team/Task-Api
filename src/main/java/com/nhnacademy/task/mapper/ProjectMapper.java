package com.nhnacademy.task.mapper;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectDto toDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setStatus(String.valueOf(project.getStatus()));
        return projectDto;
    }

    public Project toEntity(CreateUpdateProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStatus(ProjectStatus.valueOf(projectDto.getStatus()));
        return project;
    }
}
