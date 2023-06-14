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
public class TaskTagPk implements Serializable {
    private Long tagNum;
    private Long taskNum;
}
