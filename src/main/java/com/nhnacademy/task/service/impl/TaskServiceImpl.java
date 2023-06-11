/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : TaskServiceImpl
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.TaskDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Override
    public TaskDto createTask(Long projectId, TaskDto taskDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Task task = taskDto.toEntity(project);
        return TaskDto.fromEntity(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getTasksByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        return taskRepository.findByProject(project).stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long projectId, Long taskId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Task task = taskRepository.findByProjectAndTaskId(project, taskId)
                .orElseThrow(TaskNotFoundException::new);
        return TaskDto.fromEntity(task);
    }

    @Override
    public TaskDto updateTask(Long projectId, Long taskId, TaskDto taskDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Task task = taskRepository.findByProjectAndTaskId(project, taskId)
                .orElseThrow(TaskNotFoundException::new);
        task.update(taskDto.getTaskTitle(), taskDto.getTaskContent());
        taskRepository.save(task);
        return TaskDto.fromEntity(task);
    }


    @Override
    public void deleteTaskById(Long projectId, Long taskId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        Task task = taskRepository.findByProjectAndTaskId(project, taskId)
                .orElseThrow(TaskNotFoundException::new);
        taskRepository.delete(task);
    }
}


