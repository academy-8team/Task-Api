/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : ProjectServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.request.ProjectRequestDto;
import com.nhnacademy.task.dto.response.ProjectResponseDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectMember;
import com.nhnacademy.task.entity.ProjectRole;
import com.nhnacademy.task.entity.ProjectStatus;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private static final int NUM_PER_PAGE = 5;

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public List<ProjectResponseDto> getProjects(int page) {
        Pageable pageable = PageRequest.of(page, NUM_PER_PAGE);

        return projectRepository.findAllBy(pageable).getContent();
    }

    @Override
    public Optional<ProjectResponseDto> makeProject(
            ProjectRequestDto projectRequestDto, Long memberNum) {
        Project project = Project.builder()
                .projectName(projectRequestDto.getProjectName())
                .projectDescription(projectRequestDto.getProjectDescription())
                .projectStatus(ProjectStatus.ACTIVE)
                .build();

        Long projectNum = projectRepository.save(project).getProjectNum();

        ProjectMemberPk projectMemberPk = ProjectMemberPk.builder()
                .projectMemberNum(memberNum)
                .projectNum(project.getProjectNum())
                .build();

        ProjectMember projectMember = ProjectMember.builder()
                .projectMemberPk(projectMemberPk)
                .projectRole(ProjectRole.PROJECT_ROLE_ADMIN)
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        ProjectResponseDto projectResponseDto = projectRepository.findByProjectNum(projectNum);

        return Optional.ofNullable(projectResponseDto);
    }

    @Override
    public Optional<ProjectResponseDto> getProjectByProjectNum(Long projectNum) {
        ProjectResponseDto projectResponseDto = projectRepository.findByProjectNum(projectNum);

        return Optional.ofNullable(projectResponseDto);
    }
}
