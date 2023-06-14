package com.nhnacademy.task.dto.respond;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.enums.ProjectRole;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ProjectMemberRespondDto {
    private ProjectMemberPk projectMemberPk;

    private ProjectRole projectRole;

    private Project project;
}
