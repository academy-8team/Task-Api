package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);

    List<ProjectDto> getAccessibleProjects();

    ProjectDto getProjectById(Long projectId);

    void deleteProjectById(Long projectId);

    ProjectDto updateProject(Long projectId, ProjectDto projectDto);
}
