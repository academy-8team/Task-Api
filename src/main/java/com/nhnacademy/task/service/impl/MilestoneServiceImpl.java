/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : MilestoneServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.MilestoneDto;
import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.exception.MilestoneNotFoundException;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.repository.MilestoneRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MilestoneServiceImpl implements MilestoneService {

    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;

    @Override
    public MilestoneDto createMilestone(Long projectId, MilestoneDto milestoneDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        Milestone milestone = milestoneDto.toEntity(project);
        return MilestoneDto.fromEntity(milestoneRepository.save(milestone));
    }

    @Override
    public List<MilestoneDto> getMilestonesByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        return milestoneRepository.findByProject(project).stream()
                .map(MilestoneDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MilestoneDto getMilestoneById(Long projectId, Long milestoneId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        Milestone milestone = milestoneRepository.findByProjectAndMilestoneId(project, milestoneId)
                .orElseThrow(MilestoneNotFoundException::new);
        return MilestoneDto.fromEntity(milestone);
    }

    @Override
    public MilestoneDto updateMilestone(Long projectId, Long milestoneId, MilestoneDto milestoneDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        Milestone milestone = milestoneRepository.findByProjectAndMilestoneId(project, milestoneId)
                .orElseThrow(MilestoneNotFoundException::new);
        milestone.updateMilestoneTitle(milestoneDto.getMilestoneTitle());
        return MilestoneDto.fromEntity(milestoneRepository.save(milestone));
    }

    @Override
    public void deleteMilestoneById(Long projectId, Long milestoneId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        Milestone milestone = milestoneRepository.findByProjectAndMilestoneId(project, milestoneId)
                .orElseThrow(MilestoneNotFoundException::new);
        milestoneRepository.delete(milestone);
    }
}
