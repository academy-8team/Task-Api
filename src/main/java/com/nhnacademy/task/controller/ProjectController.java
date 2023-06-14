package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.request.ProjectRequestDto;
import com.nhnacademy.task.dto.respond.ProjectRespondDto;
import com.nhnacademy.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create/{memberNum}")
    public ResponseEntity<?> createProject(@Valid @RequestBody ProjectRequestDto projectRequestDto,
                                           BindingResult bindingResult,
                                           @PathVariable(name = "memberNum") Long memberNum) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Project Validation이 실패했습니다.");
        }

        Optional<ProjectRespondDto> project = projectService.makeProject(projectRequestDto, memberNum);

        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("프로젝트를 생성하는데 실패했습니다.");
        }
    }

    @GetMapping("/{projectNum}")
    public ResponseEntity<ProjectRespondDto> getProject(@PathVariable(name = "projectNum") Long projectNum) {

        Optional<ProjectRespondDto> project = projectService.getProjectByProjectNum(projectNum);

        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
