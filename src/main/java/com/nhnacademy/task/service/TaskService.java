/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TaskService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.request.TaskRequestDto;
import com.nhnacademy.task.dto.response.TaskResponseDto;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    String createTask(TaskRequestDto taskRequestDto,
                      Long projectNum);

    Optional<TaskResponseDto> findTaskDetail(Long projectNum, Long taskNum);

    List<TaskResponseDto> findTaskAll(Long projectNum);

    String updateTask(TaskRequestDto taskRequestDto, Long projectNum, Long taskNum);

    String deleteTask(Long projectNum, Long taskNum);

    String registerMilestone(Long projectNum, Long taskNum, Long milestoneNum);

    String registerTag(Long projectNum, Long taskNum, Long tagNum);
}

