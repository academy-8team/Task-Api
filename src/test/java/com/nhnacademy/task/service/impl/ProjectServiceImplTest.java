package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.ProjectDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.repository.ProjectRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private ProjectDto projectDto;
    private Project project;
    private Long projectId = 1L;

    @BeforeEach
    void setUp() {
        projectDto = new ProjectDto(null, "Test Project", "This is a test project", ProjectStatus.ACTIVE);
        project = projectDto.toEntity();
    }

    @Test
    void testCreateProject() {

        ProjectDto result = projectService.createProject(projectDto);

        assertEquals(projectId, result.getProjectId());
        assertEquals(projectDto.getProjectName(), result.getProjectName());
        assertEquals(projectDto.getProjectDescription(), result.getProjectDescription());
    }

    @Test
    void testGetProjectById() {
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

        ProjectDto result = projectService.getProjectById(projectId);

        assertEquals(projectId, result.getProjectId());
        assertEquals(project.getProjectName(), result.getProjectName());
        assertEquals(project.getProjectDescription(), result.getProjectDescription());
    }

    @Test
    void testGetProjectByIdNotFound() {
        when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> {
            projectService.getProjectById(projectId);
        });
    }

    @Test
    void testDeleteProjectById() {
        when(projectRepository.existsById(projectId)).thenReturn(true);

        // Should not throw an exception
        assertDoesNotThrow(() -> projectService.deleteProjectById(projectId));
    }

    @Test
    void testDeleteProjectByIdNotFound() {
        when(projectRepository.existsById(projectId)).thenReturn(false);

        assertThrows(ProjectNotFoundException.class, () -> {
            projectService.deleteProjectById(projectId);
        });
    }

    @Test
    void testUpdateProject() {
        ProjectDto updatedDto = new ProjectDto(projectId, "Updated Project", "Updated Description", ProjectStatus.ACTIVE);
        Project updatedProject = updatedDto.toEntity();

        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

        ProjectDto result = projectService.updateProject(projectId, updatedDto);

        assertEquals(updatedDto.getProjectName(), result.getProjectName());
        assertEquals(updatedDto.getProjectDescription(), result.getProjectDescription());
    }

    @Test
    void testUpdateProjectNotFound() {
        when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

        assertThrows(ProjectNotFoundException.class, () -> {
            projectService.updateProject(projectId, projectDto);
        });
    }
}
