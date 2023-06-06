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
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping("/project/member/{memberNum}")
    public List<ProjectMemberResponseDto> getProjectList(@PathVariable(name = "memberNum") Long memberNum, @RequestParam(name = "page") int page) {
        return projectMemberService.getProjects(memberNum, page);
    }

    @GetMapping("/project/{projectNum}/member/administrator")
    public Optional<ProjectMemberResponseDto> getProjectAdministrator(@PathVariable(name = "projectNum") Long projectNum) {
        return projectMemberService.getProjectAdministratorByProjectNum(projectNum);
    }

    @GetMapping("/project/{projectNum}/member/register")
    public String registerProjectMember(@PathVariable(name = "projectNum") Long projectNum, @RequestParam(name = "memberNum") Long memberNum) {
        return projectMemberService.registerProjectMember(projectNum, memberNum);
    }
}
