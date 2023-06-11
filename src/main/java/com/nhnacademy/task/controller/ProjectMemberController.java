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

import com.nhnacademy.task.dto.ProjectMemberDto;
import com.nhnacademy.task.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @PostMapping
    public ResponseEntity<?> createProjectMember(@PathVariable Long projectId, @Valid @RequestBody ProjectMemberDto projectMemberDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectMemberService.createProjectMember(projectId, projectMemberDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectMemberDto>> getProjectMembers(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectMemberService.getProjectMembers(projectId), HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ProjectMemberDto> getProjectMember(@PathVariable Long projectId, @PathVariable Long memberId) {
        return new ResponseEntity<>(projectMemberService.getProjectMemberById(projectId, memberId), HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteProjectMember(@PathVariable Long projectId, @PathVariable Long memberId) {
        projectMemberService.deleteProjectMemberById(projectId, memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

