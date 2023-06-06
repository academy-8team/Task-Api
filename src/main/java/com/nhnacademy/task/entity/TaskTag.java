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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
