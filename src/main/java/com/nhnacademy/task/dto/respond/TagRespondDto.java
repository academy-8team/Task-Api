package com.nhnacademy.task.dto.respond;

import com.nhnacademy.task.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TagRespondDto {
    private Long tagNum;

    private Project project;

    private String tagTitle;
}
