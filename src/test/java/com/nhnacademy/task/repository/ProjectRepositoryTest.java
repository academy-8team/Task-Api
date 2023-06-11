package com.nhnacademy.task.repository;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void testSaveProject() {
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        Project savedProject = projectRepository.save(project);

        assertNotNull(savedProject.getProjectId());
        assertEquals("Test Project", savedProject.getProjectName());
    }

    @Test
    void testFindById() {
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        Project savedProject = entityManager.persistAndFlush(project);

        Optional<Project> foundProject = projectRepository.findById(savedProject.getProjectId());

        assertTrue(foundProject.isPresent());
        assertEquals("Test Project", foundProject.get().getProjectName());
    }

    @Test
    void testDeleteById() {
        Project project = Project.builder()
                .projectName("Test Project")
                .projectDescription("Test Description")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        Project savedProject = entityManager.persistAndFlush(project);

        projectRepository.deleteById(savedProject.getProjectId());

        Optional<Project> foundProject = projectRepository.findById(savedProject.getProjectId());

        assertFalse(foundProject.isPresent());
    }

    @Test
    void testFindAll() {
        Project project1 = Project.builder()
                .projectName("Test Project 1")
                .projectDescription("Test Description 1")
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        Project project2 = Project.builder()
                .projectName("Test Project 2")
                .projectDescription("Test Description 2")
                .projectStatus(ProjectStatus.DORMANT)
                .build();

        entityManager.persistAndFlush(project1);
        entityManager.persistAndFlush(project2);

        List<Project> projects = projectRepository.findAll();

        assertEquals(2, projects.size());
    }
}
