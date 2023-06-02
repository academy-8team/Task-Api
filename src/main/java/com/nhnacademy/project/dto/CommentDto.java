package com.nhnacademy.project.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String content;
    private Long taskId;
}