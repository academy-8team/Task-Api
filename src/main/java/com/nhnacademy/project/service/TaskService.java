package com.nhnacademy.project.service;

import com.nhnacademy.project.entity.Milestone;
import com.nhnacademy.project.entity.Task;
import com.nhnacademy.project.repository.MilestoneRepository;
import com.nhnacademy.project.repository.TaskRepository;
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
        task.setMilestone(milestone);
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
