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

import com.nhnacademy.task.dto.ProjectMemberDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectMember;
import com.nhnacademy.task.exception.ProjectMemberNotFoundException;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectMemberDto createProjectMember(Long projectId, ProjectMemberDto projectMemberDto) {
        Project project = getProject(projectId);
        ProjectMember projectMember = projectMemberDto.toEntity(project);
        return ProjectMemberDto.fromEntity(projectMemberRepository.save(projectMember));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProjectMemberDto> getProjectMembers(Long projectId) {
        Project project = getProject(projectId);
        return projectMemberRepository.findByProject(project).stream()
                .map(ProjectMemberDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ProjectMemberDto getProjectMemberById(Long projectId, Long projectMemberNum) {
        Project project = getProject(projectId);
        ProjectMember projectMember = projectMemberRepository.findByProjectAndProjectMemberId(project, projectMemberNum)
                .orElseThrow(ProjectMemberNotFoundException::new);
        return ProjectMemberDto.fromEntity(projectMember);
    }

    @Override
    public void deleteProjectMemberById(Long projectId, Long projectMemberNum) {
        Project project = getProject(projectId);
        ProjectMember projectMember = projectMemberRepository.findByProjectAndProjectMemberId(project, projectMemberNum)
                .orElseThrow(ProjectMemberNotFoundException::new);
        projectMemberRepository.delete(projectMember);
    }

    private Project getProject(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
    }
}
