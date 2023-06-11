/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : ProjectDto
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long projectId;

    @NotNull
    @Size(min = 2, max = 30)
    private String projectName;

    @Size(max = 200)
    private String projectDescription;

    private ProjectStatus projectStatus;

    public Project toEntity() {
        return Project.builder()
                .projectName(this.projectName)
                .projectDescription(this.projectDescription)
                .projectStatus(this.projectStatus)
                .build();
    }

    public static ProjectDto fromEntity(Project project) {
        return new ProjectDto(project.getProjectId(), project.getProjectName(), project.getProjectDescription(), project.getProjectStatus());
    }
}