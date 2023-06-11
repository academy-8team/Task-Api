package com.nhnacademy.task.entity;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ProjectTest {

    @Test
    void testProjectBuilder() {
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        assertEquals("Test Project", project.getProjectName());
        assertEquals("Test Description", project.getProjectDescription());
        assertEquals(ProjectStatus.ACTIVE, project.getProjectStatus());
    }

    @Test
    void testUpdateAttributes() {
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        project.updateAttributes("Updated Project", "Updated Description", ProjectStatus.ACTIVE);

        assertEquals("Updated Project", project.getProjectName());
        assertEquals("Updated Description", project.getProjectDescription());
        assertEquals(ProjectStatus.SHUTDOWN, project.getProjectStatus());
    }
}
