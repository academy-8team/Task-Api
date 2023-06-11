/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : ProjectMember
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

import com.nhnacademy.task.entity.pk.ProjectMemberPk;

import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "project_members")
public class ProjectMember extends BaseTimeEntity {

    @EmbeddedId
    private ProjectMemberPk projectMemberPk;

    @Enumerated(EnumType.STRING)
    private ProjectRole projectRole;

    @MapsId("projectId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public ProjectMember(ProjectMemberPk projectMemberPk, ProjectRole projectRole, Project project) {
        this.projectMemberPk = projectMemberPk;
        this.projectRole = projectRole;
        this.project = project;
    }
}
