package com.nhnacademy.task.dto.respond;

import com.nhnacademy.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommentRespondDto {
    private Long commentNum;

    private Task task;

    private String commentContent;

    private String writerId;
}
