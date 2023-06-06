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

import java.util.List;

public interface MilestoneService {
    String createMilestone(Long projectNum, String milestoneTitle);

    List<com.nhnacademy.task.dto.respond.MilestoneResponseDto> findAllMilestone(Long projectNum);

    String updateTag(Long projectNum, Long milestoneNum, String milestoneTitle);

    String deleteTag(Long projectNum, Long milestoneNum);

    List<com.nhnacademy.task.dto.respond.MilestoneResponseDto> getMilestoneByProjectNum(Long projectNum, Long taskNum);

    String getMilestoneByTaskNum(Long projectNum, Long taskNum);
}
