package com.nhnacademy.task.service;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import com.nhnacademy.task.mapper.ProjectMapper;
import com.nhnacademy.task.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectDto createProject(CreateUpdateProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }

    public ProjectDto getProject(Long projectId) {
        Project project = getProjectEntity(projectId);
        return projectMapper.toDto(project);
    }

    public ProjectDto updateProject(Long projectId, CreateUpdateProjectDto projectDto) {
        Project project = getProjectEntity(projectId);
        project.setName(projectDto.getName());
        project.setStatus(ProjectStatus.valueOf(projectDto.getStatus()));
        Project updatedProject = projectRepository.save(project);
        return projectMapper.toDto(updatedProject);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    private Project getProjectEntity(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
