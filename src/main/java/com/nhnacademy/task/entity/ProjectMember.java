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
@Getter// todo 4 : Project Entity에  Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
@Entity
public class ProjectMember {
    @EmbeddedId
    private ProjectMemberPk projectMemberPk;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_role")
    private ProjectRole projectRole;

    @MapsId("projectNum")
    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;
}
