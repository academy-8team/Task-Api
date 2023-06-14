package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.ProjectMemberRespondDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberService { // todo 15 - pageable interface를 이용할 것을 고려합니다.
    List<ProjectMemberRespondDto> getProjects(Long memberNum, int page);

    Optional<ProjectMemberRespondDto> getProjectAdministratorByProjectNum(Long projectNum);

    String registerProjectMember(Long projectNum, Long memberNum);
}
