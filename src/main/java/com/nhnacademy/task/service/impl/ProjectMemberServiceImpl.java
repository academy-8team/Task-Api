/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : ProjectMemberServiceImpl
 * author :  ichunghui
 * date : 2023/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.response.ProjectMemberResponseDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectMember;
import com.nhnacademy.task.entity.ProjectRole;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.AlreadyExistMemberId;
import com.nhnacademy.task.service.ProjectMemberService;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    private static final int NUM_PER_PAGE = 5;

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectMemberResponseDto> getProjects(Long memberNum, int page) {
        Pageable pageable = PageRequest.of(page, NUM_PER_PAGE);

        return projectMemberRepository.findByProjectMemberPkProjectMemberNum(memberNum, pageable)
                .getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectMemberResponseDto getProjectAdministratorByProjectNum(Long projectNum) {
        return Optional.ofNullable(projectMemberRepository.findByProjectMemberPkProjectNumAndProjectRole(projectNum,
                ProjectRole.PROJECT_ROLE_ADMIN.toString()));
    }
    @Override
    @Transactional
    public String registerProjectMember(Long projectNum, Long memberNum) {
        ProjectMemberPk projectMemberPk = ProjectMemberPk.builder()
                .projectNum(projectNum)
                .projectMemberNum(memberNum)
                .build();

        if (projectMemberRepository.existsById(projectMemberPk)) {
            throw new AlreadyExistMemberId()
        }

        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로젝트 입니다."));

        ProjectMember projectMember = ProjectMember.builder()
                .projectMemberPk(projectMemberPk)
                .project(project)
                .projectRole(ProjectRole.PROJECT_ROLE_USER)
                .build();

        projectMemberRepository.save(projectMember);

        return "해당 멤버가 저장되었습니다.";
    }
}

