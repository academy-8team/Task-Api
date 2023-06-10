/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : TaskTag
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

import com.nhnacademy.task.entity.pk.TaskTagPk;

import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "task_tags")
public class TaskTag extends BaseTimeEntity {

    @EmbeddedId
    private TaskTagPk taskTagPk;

    @MapsId("tagNum")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_num")
    private Tag tag;

    @MapsId("taskNum")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_num")
    private Task task;

    @Builder
    public TaskTag(TaskTagPk taskTagPk, Tag tag, Task task) {
        this.taskTagPk = taskTagPk;
        this.tag = tag;
        this.task = task;
    }
}
