package com.nhnacademy.task.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import org.junit.jupiter.api.Test;

class ProjectDtoTest {

    @Test
    void testToEntity() {
        ProjectDto projectDto = new ProjectDto(null, "Test Project", "Test Description", ProjectStatus.ACTIVE);

        Project project = projectDto.toEntity();

        assertEquals("Test Project", project.getProjectName());
        assertEquals("Test Description", project.getProjectDescription());
        assertEquals(ProjectStatus.ACTIVE, project.getProjectStatus());
    }
}
