package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long taskId;
    private String taskTitle;
    private String taskContent;

    public Task toEntity(Project project) {
        return Task.builder()
                .project(project)
                .taskTitle(this.taskTitle)
                .taskContent(this.taskContent)
                .build();
    }

    public static TaskDto fromEntity(Task task) {
        return new TaskDto(task.getTaskId(), task.getTaskTitle(), task.getTaskContent());
    }
}
