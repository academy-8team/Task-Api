package com.nhnacademy.task.entity.pk;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class ProjectMemberPk implements Serializable {
    @Column(name = "project_member_num")
    private Long projectMemberNum;

    @Column(name = "project_num")
    private Long projectNum;
}
