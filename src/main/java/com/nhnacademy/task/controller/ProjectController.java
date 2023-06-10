/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : ProjectController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.ProjectDto;
import com.nhnacademy.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAccessibleProjects() {
        return ResponseEntity.ok(projectService.getAccessibleProjects());
    }

    @GetMapping("/{project-id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("project-id") Long projectId) {
        try {
            return ResponseEntity.ok(projectService.getProjectById(projectId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{project-id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable("project-id") Long projectId) {
        try {
            projectService.deleteProjectById(projectId);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{project-id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("project-id") Long projectId, @Valid @RequestBody ProjectDto projectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(projectService.updateProject(projectId, projectDto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
