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

import com.nhnacademy.task.dto.response.MilestoneResponseDto;
import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.repository.MilestoneRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.MilestoneService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public String createMilestone(Long projectNum, String milestoneTitle) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        Milestone milestone = Milestone.builder()
                .milestoneTitle(milestoneTitle)
                .project(project)
                .build();

        milestoneRepository.save(milestone);

        return "마일스톤이 저장되었습니다.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilestoneResponseDto> findAllMilestone(Long projectNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        return milestoneRepository.findByProject(project);
    }

    @Override
    @Transactional
    public String updateMilestone(Long projectNum, Long milestoneNum, String milestoneTitle) {
        Milestone updateMilestone = milestoneRepository.findById(milestoneNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 마일스톤이 존재하지 않습니다."));

        updateMilestone.setMilestoneTitle(milestoneTitle);

        milestoneRepository.save(updateMilestone);

        return "해당 마일스톤이 수정되었습니다.";
    }

    @Override
    @Transactional
    public String deleteMilestone(Long projectNum, Long milestoneNum) {
        if (!milestoneRepository.existsById(milestoneNum)) {
            return "해당 마일스톤이 존재하지 않습니다.";
        }

        milestoneRepository.deleteById(milestoneNum);

        return "해당 마일스톤이 삭제되었습니다";
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilestoneResponseDto> getMilestoneByProjectNum(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        return milestoneRepository.findByProject(project);
    }

    @Override
    public String getMilestoneByTaskNum(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new RuntimeException("해당 프로젝트가 존재하지 않습니다"));

        if (taskRepository.findByProjectAndTaskNum(project, taskNum).getMilestone() == null) {
            return null;
        }

        return taskRepository.findByProjectAndTaskNum(project, taskNum).getMilestone()
                .getMilestoneTitle();

    }
}
