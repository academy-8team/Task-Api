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
@Entity // todo 7 -  Task Entity에  Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
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
