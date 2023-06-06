/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : ProjectMemberController
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.response.ProjectMemberResponseDto;
import com.nhnacademy.task.service.ProjectMemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping("/project/member/{memberNum}")
    public ResponseEntity<List<ProjectMemberResponseDto>> getProjectList(@PathVariable(name = "memberNum") Long memberNum, @RequestParam(name = "page") int page) {
        List<ProjectMemberResponseDto> projectMembers = projectMemberService.getProjects(memberNum, page);
        return ResponseEntity.ok().body(projectMembers);
    }

    @GetMapping("/project/{projectNum}/member/administrator")
    public ResponseEntity<ProjectMemberResponseDto> getProjectAdministrator(@PathVariable(name = "projectNum") Long projectNum) {
        return projectMemberService.getProjectAdministratorByProjectNum(projectNum)
                .map(projectMember -> ResponseEntity.ok().body(projectMember))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/project/{projectNum}/member/register")
    public ResponseEntity<String> registerProjectMember(@PathVariable(name = "projectNum") Long projectNum, @RequestParam(name = "memberNum") Long memberNum) {
        String result = projectMemberService.registerProjectMember(projectNum, memberNum);
        if (result.equals("Project member registration successful")) {
            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
