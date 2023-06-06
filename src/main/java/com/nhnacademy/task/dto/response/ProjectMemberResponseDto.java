/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : ProjectMemberResponseDto
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
import com.nhnacademy.task.entity.ProjectRole;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ProjectMemberResponseDto {
    private ProjectMemberPk projectMemberPk;

    private ProjectRole projectRole;

    private Project project;
}
