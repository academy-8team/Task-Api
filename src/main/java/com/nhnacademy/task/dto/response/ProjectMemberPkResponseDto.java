package com.nhnacademy.task.dto.response; /**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : ProjectMemberPkResponseDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectMemberPkResponseDto {
    private Long projectMemberNum;
    private Long projectNum;
}
