package com.nhnacademy.project.service;

import com.nhnacademy.project.dto.CreateUpdateMilestoneDto;
import com.nhnacademy.project.dto.MilestoneDto;
import com.nhnacademy.project.entity.Milestone;
import com.nhnacademy.project.entity.Project;
import com.nhnacademy.project.mapper.MilestoneMapper;
import com.nhnacademy.project.repository.MilestoneRepository;
import com.nhnacademy.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneMapper milestoneMapper;

    public MilestoneDto createMilestone(Long projectId, CreateUpdateMilestoneDto milestoneDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Milestone milestone = milestoneMapper.toEntity(milestoneDto, project);
        Milestone savedMilestone = milestoneRepository.save(milestone);
        return milestoneMapper.toDto(savedMilestone);
    }

    public List<MilestoneDto> getMilestones(Long projectId) {
        return milestoneRepository.findByProjectId(projectId)
                .stream()
                .map(milestoneMapper::toDto)
                .collect(Collectors.toList());
    }

    public MilestoneDto getMilestone(Long projectId, Long milestoneId) {
        Milestone milestone = getMilestoneEntity(projectId, milestoneId);
        return milestoneMapper.toDto(milestone);
    }

    public MilestoneDto updateMilestone(Long projectId, Long milestoneId, CreateUpdateMilestoneDto milestoneDto) {
        Milestone milestone = getMilestoneEntity(projectId, milestoneId);
        milestone.setName(milestoneDto.getName());
        Milestone updatedMilestone = milestoneRepository.save(milestone);
        return milestoneMapper.toDto(updatedMilestone);
    }

    public void deleteMilestone(Long projectId, Long milestoneId) {
        Milestone milestone = getMilestoneEntity(projectId, milestoneId);
        milestoneRepository.delete(milestone);
    }

    private Milestone getMilestoneEntity(Long projectId, Long milestoneId) {
        return milestoneRepository.findByIdAndProjectId(milestoneId, projectId)
                .orElseThrow(() -> new RuntimeException("Milestone not found"));
    }
}
