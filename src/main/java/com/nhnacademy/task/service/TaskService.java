package com.nhnacademy.task.service;

import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.repository.MilestoneRepository;
import com.nhnacademy.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final MilestoneRepository milestoneRepository;

    public Task createTask(Long milestoneId, Task task) {
        Milestone milestone = milestoneRepository.findById(milestoneId)
                .orElseThrow(() -> new RuntimeException("Milestone not found"));
        task.setTaskMileStones(milestone.getTaskMileStones());
        return taskRepository.save(task);
    }


    public Task getTask(Long projectId, Long taskId) {
        return taskRepository.findByIdAndProjectId(taskId, projectId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(Long projectId, Long taskId, Task updatedTask) {
        Task existingTask = getTask(projectId, taskId);
        existingTask.setContent(updatedTask.getContent());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long projectId, Long taskId) {
        Task task = getTask(projectId, taskId);
        taskRepository.delete(task);
    }
}
