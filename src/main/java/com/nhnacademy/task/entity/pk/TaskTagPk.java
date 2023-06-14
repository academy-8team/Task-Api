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
public class TaskTagPk implements Serializable {
    @Column(name = "tag_num")
    private Long tagNum;

    @Column(name = "task_num")
    private Long taskNum;
}
