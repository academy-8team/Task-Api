/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : ProjectMemberDto
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
import com.nhnacademy.task.entity.ProjectMember;
import com.nhnacademy.task.entity.ProjectRole;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberDto {

    private Long projectMemberNum;
    private Long projectNum;
    private ProjectRole projectRole;

    public ProjectMember toEntity(Project project) {
        return ProjectMember.builder()
                .projectMemberPk(new ProjectMemberPk(this.projectMemberNum, this.projectNum))
                .projectRole(this.projectRole)
                .project(project)
                .build();
    }

    public static ProjectMemberDto fromEntity(ProjectMember projectMember) {
        return new ProjectMemberDto(
                projectMember.getProjectMemberPk().getProjectMemberId(),
                projectMember.getProjectMemberPk().getProjectId(),
                projectMember.getProjectRole()
        );
    }
}
