/**
 * packageName :  com.nhnacademy.task.dto.request
 * fileName : ProjectRequestDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.nhnacademy.task.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectRequestDto {
    private Long projectNum;

    private Long projectAdministratorNum;

    private String projectName;

    private String projectDescription;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
}
