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

package com.nhnacademy.project.controller;

import com.nhnacademy.project.dto.CreateUpdateProjectDto;
import com.nhnacademy.project.dto.ProjectDto;
import com.nhnacademy.project.entity.Project;
import com.nhnacademy.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody CreateUpdateProjectDto projectDto) {
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long projectId, @RequestBody CreateUpdateProjectDto projectDto) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectDto));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
