/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : ProjectServiceImpl
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.ProjectDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = projectDto.toEntity();
        project = projectRepository.save(project);
        projectDto.setProjectId(project.getProjectId());
        return projectDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProjectDto> getAccessibleProjects() {
        return projectRepository.findAll().stream()
                .map(ProjectDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ProjectDto getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .map(ProjectDto::fromEntity)
                .orElseThrow(ProjectNotFoundException::new);
    }

    @Override
    public void deleteProjectById(Long projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException();
        }
        projectRepository.deleteById(projectId);
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        Project existingProject = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);

        existingProject.updateAttributes(projectDto.getProjectName(), projectDto.getProjectDescription(), projectDto.getProjectStatus());

        existingProject = projectRepository.save(existingProject);

        return ProjectDto.fromEntity(existingProject);
    }
}
