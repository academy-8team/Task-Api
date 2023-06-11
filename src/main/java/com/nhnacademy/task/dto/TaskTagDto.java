/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : TaskTagDto
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.TaskTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskTagDto {

    private Long tagId;
    private Long taskId;

    public static TaskTagDto fromEntity(TaskTag taskTag) {
        return new TaskTagDto(taskTag.getTag().getTagId(), taskTag.getTask().getTaskId());
    }
}
