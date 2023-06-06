/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : ProjectResponseDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto.response;

import com.nhnacademy.task.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ProjectResponseDto {
    private Long projectNum;

    private String projectName;

    private String projectDescription;

    private ProjectStatus projectStatus;
}
