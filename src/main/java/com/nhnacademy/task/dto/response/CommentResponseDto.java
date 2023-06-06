/**
 * packageName :  com.nhnacademy.task.dto.response
 * fileName : CommentRequestDto
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto.response;

import com.nhnacademy.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommentResponseDto {
    private Long commentNum;

    private Task task;

    private String commentContent;

    private String writerId;
}
