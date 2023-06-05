package com.nhnacademy.project.mapper;

import com.nhnacademy.project.dto.CreateUpdateMilestoneDto;
import com.nhnacademy.project.dto.MilestoneDto;
import com.nhnacademy.project.entity.Milestone;
import com.nhnacademy.project.entity.Project;
import com.nhnacademy.project.entity.TaskMileStone;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MilestoneMapper {

    public MilestoneDto toDto(Milestone milestone) {
        MilestoneDto milestoneDto = new MilestoneDto();
        milestoneDto.setId(milestone.getId());
        milestoneDto.setName(milestone.getName());
        milestoneDto.setProjectId(milestone.getId());
        return milestoneDto;
    }

    public Milestone toEntity(CreateUpdateMilestoneDto milestoneDto, Project project) {
        Milestone milestone = new Milestone();
        milestone.setName(milestoneDto.getName());
        milestone.setTaskMileStones((Set<TaskMileStone>) project);
        return milestone;
    }
}
