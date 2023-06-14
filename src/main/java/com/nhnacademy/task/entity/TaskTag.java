package com.nhnacademy.task.entity;

import com.nhnacademy.task.entity.pk.TaskTagPk;
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
public class TaskTag {
    @EmbeddedId
    private TaskTagPk taskTagPk;

    @MapsId("tagNum")
    @ManyToOne
    @JoinColumn(name = "tag_num")
    private Tag tag;

    @MapsId("taskNum")
    @ManyToOne
    @JoinColumn(name = "task_num")
    private Task task;
}
