package com.nhnacademy.task.dto.request;

import com.nhnacademy.task.entity.enums.ProjectState;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@Data
public class ProjectRequestDto {
    private Long projectNum;

    private Long projectAdministratorNum;

    private String projectName;

    private String projectDescription;

    @Enumerated(EnumType.STRING)
    private ProjectState projectState;
}
