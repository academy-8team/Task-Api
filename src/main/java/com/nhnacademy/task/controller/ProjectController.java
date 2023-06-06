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
import com.nhnacademy.task.dto.response.ProjectResponseDto;
import com.nhnacademy.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/project/create/{memberNum}")
    public Optional<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto projectRequestDto,
                                                      @PathVariable(name = "memberNum") Long memberNum) {
        return projectService.makeProject(projectRequestDto, memberNum);
    }

    @GetMapping("/project/{projectNum}")
    public Optional<ProjectResponseDto> getProject(@PathVariable(name = "projectNum") Long projectNum) {
        return projectService.getProjectByProjectNum(projectNum);
    }
}
