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

import com.nhnacademy.task.dto.response.ProjectMemberResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberService {
    List<ProjectMemberResponseDto> getProjects(Long memberNum, int page);

    Optional<ProjectMemberResponseDto> getProjectAdministratorByProjectNum(Long projectNum);

    String registerProjectMember(Long projectNum, Long memberNum);
}
