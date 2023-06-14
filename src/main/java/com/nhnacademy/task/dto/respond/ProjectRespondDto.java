package com.nhnacademy.task.dto.respond;

import com.nhnacademy.task.entity.enums.ProjectState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProjectRespondDto {
    private Long projectNum;

    private String projectName;

    private String projectDescription;

    private ProjectState projectState;
}
