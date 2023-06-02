/**
 * packageName :  com.nhnacademy.project.dto
 * fileName : TaskDto
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.project.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String content;
    private Long milestoneId;
}

