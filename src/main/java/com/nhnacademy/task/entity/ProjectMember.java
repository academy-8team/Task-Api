package com.nhnacademy.task.entity;


import com.nhnacademy.task.entity.enums.ProjectRole;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ProjectMember {
    @EmbeddedId
    private ProjectMemberPk projectMemberPk;

    @Enumerated(EnumType.STRING)
    private ProjectRole projectRole;

    @MapsId("projectNum")
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;
}
