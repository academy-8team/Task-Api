/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : TaskResponseDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto.response;

import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TaskResponseDto {
    private Long taskNum;

    private Project project;

    private Milestone milestone;

    private String taskTitle;

    private String taskContent;
}
