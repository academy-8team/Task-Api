/**
 * packageName :  com.nhnacademy.task.service
 * fileName : ProjectMemberService
 * author :  ichunghui
 * date : 2023/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.ProjectMemberDto;

import java.util.List;

public interface ProjectMemberService {

    ProjectMemberDto createProjectMember(Long projectId, ProjectMemberDto projectMemberDto);

    List<ProjectMemberDto> getProjectMembers(Long projectId);

    ProjectMemberDto getProjectMemberById(Long projectId, Long projectMemberNum);

    void deleteProjectMemberById(Long projectId, Long projectMemberNum);
}
