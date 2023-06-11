/**
 * packageName :  com.nhnacademy.task.service
 * fileName : MilestoneService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.MilestoneDto;

import java.util.List;

public interface MilestoneService {

    MilestoneDto createMilestone(Long projectId, MilestoneDto milestoneDto);

    List<MilestoneDto> getMilestonesByProjectId(Long projectId);

    MilestoneDto getMilestoneById(Long projectId, Long milestoneId);

    MilestoneDto updateMilestone(Long projectId, Long milestoneId, MilestoneDto milestoneDto);

    void deleteMilestoneById(Long projectId, Long milestoneId);
}
