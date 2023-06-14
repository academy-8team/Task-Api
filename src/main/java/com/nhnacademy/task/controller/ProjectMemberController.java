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

import com.nhnacademy.task.dto.respond.ProjectMemberRespondDto;
import com.nhnacademy.task.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController // todo 10 - restful하게 api를 수정하고, 네이밍 규칙을 지킵니다. 또한, ResponseEntity와 @Valid, BindingResult를 사용합니다. Pageable 인터페이스를 고려합니다.
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping("/project/member/{memberNum}")
    public List<ProjectMemberRespondDto> getProjectList(@PathVariable(name = "memberNum") Long memberNum, @RequestParam(name = "page") int page) {
        return projectMemberService.getProjects(memberNum, page);
    }

    @GetMapping("/project/{projectNum}/member/administrator")
    public Optional<ProjectMemberRespondDto> getProjectAdministrator(@PathVariable(name = "projectNum") Long projectNum) {
        return projectMemberService.getProjectAdministratorByProjectNum(projectNum);
    }

    @GetMapping("/project/{projectNum}/member/register")
    public String registerProjectMember(@PathVariable(name = "projectNum") Long projectNum, @RequestParam(name = "memberNum") Long memberNum) {
        return projectMemberService.registerProjectMember(projectNum, memberNum);
    }
}
