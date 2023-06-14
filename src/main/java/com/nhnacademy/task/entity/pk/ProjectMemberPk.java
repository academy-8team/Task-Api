package com.nhnacademy.task.entity.pk;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class ProjectMemberPk implements Serializable {
    private Long projectMemberNum;
    private Long projectNum;
}
