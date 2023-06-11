/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : CommentDto
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long commentId;
    private String content;

    public Comment toEntity(Task task) {
        return Comment.builder()
                .task(task)
                .content(this.content)
                .build();
    }

    public static CommentDto fromEntity(Comment comment) {
        return new CommentDto(comment.getCommentId(), comment.getContent());
    }
}
