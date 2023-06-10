package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.ProjectDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import com.nhnacademy.task.repository.ProjectRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProject() {
        ProjectDto projectDto = new ProjectDto(null, "Test Project", "Test Description", ProjectStatus.ACTIVE);
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        ProjectDto result = projectService.createProject(projectDto);

        assertEquals("Test Project", result.getProjectName());
    }

    @Test
    void testGetAccessibleProjects() {
        List<Project> projects = Arrays.asList(
                Project.builder().projectName("Project 1").projectStatus(ProjectStatus.ACTIVE).build(),
                Project.builder().projectName("Project 2").projectStatus(ProjectStatus.SHUTDOWN).build()
        );
        when(projectRepository.findAll()).thenReturn(projects);

        List<ProjectDto> result = projectService.getAccessibleProjects();

        assertEquals(2, result.size());
        assertEquals("Project 1", result.get(0).getProjectName());
    }

    @Test
    void testGetProjectById() {
        Project project = Project.builder().projectName("Test Project").projectDescription("Test Description").projectStatus(ProjectStatus.ACTIVE).build();
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        ProjectDto result = projectService.getProjectById(1L);

        assertEquals("Test Project", result.getProjectName());
    }

    @Test
    void testDeleteProjectById() {
        doNothing().when(projectRepository).deleteById(1L);

        assertDoesNotThrow(() -> projectService.deleteProjectById(1L));
    }

    @Test
    void testUpdateProject() {
        Project project = Project.builder().projectName("Test Project").projectDescription("Test Description").projectStatus(ProjectStatus.ACTIVE).build();
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        ProjectDto updatedProjectDto = new ProjectDto(null, "Updated Project", "Updated Description", ProjectStatus.ACTIVE);
        ProjectDto result = projectService.updateProject(1L, updatedProjectDto);

        assertEquals("Updated Project", result.getProjectName());
        assertEquals("Updated Description", result.getProjectDescription());
    }
}
