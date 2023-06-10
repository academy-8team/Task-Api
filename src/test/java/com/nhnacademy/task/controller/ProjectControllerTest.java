package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.ProjectDto;
import com.nhnacademy.task.entity.ProjectStatus;
import com.nhnacademy.task.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Test
    void testCreateProject() throws Exception {
        ProjectDto projectDto = new ProjectDto(null, "Test Project", "Description", ProjectStatus.ACTIVE);
        when(projectService.createProject(any(ProjectDto.class))).thenReturn(projectDto);

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"projectName\":\"Test Project\",\"projectDescription\":\"Description\",\"projectStatus\":\"ACTIVE\"}"))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.projectName", is("Test Project")));
    }

    @Test
    void testGetAllProjects() throws Exception {
        List<ProjectDto> projects = Arrays.asList(
                new ProjectDto(1L, "Project 1", "Description 1", ProjectStatus.ACTIVE),
                new ProjectDto(2L, "Project 2", "Description 2", ProjectStatus.INACTIVE)
        );
        when(projectService.getAccessibleProjects()).thenReturn(projects);

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].projectName", is("Project 1")))
                .andExpect((ResultMatcher) jsonPath("$[1].projectName", is("Project 2")));
    }

    @Test
    void testGetProjectById() throws Exception {
        ProjectDto projectDto = new ProjectDto(1L, "Test Project", "Description", ProjectStatus.ACTIVE);
        when(projectService.getProjectById(1L)).thenReturn(projectDto);

        mockMvc.perform(get("/projects/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.projectName", is("Test Project")));
    }

    @Test
    void testDeleteProjectById() throws Exception {
        doNothing().when(projectService).deleteProjectById(1L);

        mockMvc.perform(delete("/projects/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testUpdateProject() throws Exception {
        ProjectDto updatedProjectDto = new ProjectDto(1L, "Updated Project", "Updated Description", ProjectStatus.ACTIVE);
        when(projectService.updateProject(eq(1L), any(ProjectDto.class))).thenReturn(updatedProjectDto);

        mockMvc.perform(put("/projects/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"projectName\":\"Updated Project\",\"projectDescription\":\"Updated Description\",\"projectStatus\":\"ACTIVE\"}"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.projectName", is("Updated Project")));
    }
}
