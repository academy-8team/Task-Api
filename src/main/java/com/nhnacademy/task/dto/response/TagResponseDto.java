/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : TagResponseDto
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
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TagResponseDto {
    private Long tagNum;

    private Project project;

    private String tagTitle;
}
