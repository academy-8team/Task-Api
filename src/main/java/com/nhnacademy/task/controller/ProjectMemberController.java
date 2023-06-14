package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.ProjectMemberRespondDto;
import com.nhnacademy.task.exception.ProjectNotAddMember;
import com.nhnacademy.task.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping("/member/{memberNum}")
    public ResponseEntity<List<ProjectMemberRespondDto>> getProjectList(@PathVariable(name = "memberNum") Long memberNum,
                                                                        @RequestParam(name = "page") int page) {

        List<ProjectMemberRespondDto> projectList = projectMemberService.getProjects(memberNum, page);
        if (projectList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(projectList);
        }
    }

    @GetMapping("/{projectNum}/member/administrator")
    public ResponseEntity<ProjectMemberRespondDto> getProjectAdministrator(@PathVariable(name = "projectNum") Long projectNum) {

        Optional<ProjectMemberRespondDto> projectAdministrator = projectMemberService.getProjectAdministratorByProjectNum(projectNum);
        return projectAdministrator.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/{projectNum}/member/register")
    public ResponseEntity<String> registerProjectMember(@PathVariable(name = "projectNum") Long projectNum,
                                                        @RequestParam(name = "memberNum") Long memberNum) {

        String message = projectMemberService.registerProjectMember(projectNum, memberNum);
        if (message != null && !message.trim().isEmpty()) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("프로젝트에 멤버를 추가하는데 실패했습니다.");
        }
    }
}
