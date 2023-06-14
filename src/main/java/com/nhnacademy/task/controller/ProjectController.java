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
@RequestMapping("/project") // RESTful naming convention, resource should be plural
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectRespondDto> createProject(@RequestBody @Valid ProjectRequestDto projectRequestDto,
                                                           @PathVariable Long memberNum,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return projectService.createProject(projectRequestDto, memberNum)
                .map(project -> new ResponseEntity<>(project, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectRespondDto> getProject(@PathVariable Long projectId) {
        return projectService.getProjectByProjectNum(projectId)
                .map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
