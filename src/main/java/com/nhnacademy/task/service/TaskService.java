/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TaskService
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(Long projectId, TaskDto taskDto);

    List<TaskDto> getTasksByProjectId(Long projectId);

    TaskDto getTaskById(Long projectId, Long taskId);

    TaskDto updateTask(Long projectId, Long taskId, TaskDto taskDto);

    void deleteTaskById(Long projectId, Long taskId);
}
