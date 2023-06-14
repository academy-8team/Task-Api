package com.nhnacademy.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskRequestDto {
    private String taskTitle;

    private String taskContent;
}
