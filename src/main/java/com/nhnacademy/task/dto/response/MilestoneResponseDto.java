/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : MilestoneResponseDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */
package com.nhnacademy.task.dto.response;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MilestoneResponseDto {
    private Long milestoneNum;

    private Project project;

    private String milestoneTitle;

    private Task task;
}
