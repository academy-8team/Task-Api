package com.nhnacademy.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskRequestDto {
    private String taskTitle;

    private String taskContent;
}
