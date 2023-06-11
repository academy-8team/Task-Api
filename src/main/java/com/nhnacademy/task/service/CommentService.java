/**
 * packageName :  com.nhnacademy.task.service
 * fileName : CommentService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(Long projectId, Long taskId, CommentDto commentDto);

    List<CommentDto> getCommentsByTaskId(Long projectId, Long taskId);

    CommentDto getCommentById(Long projectId, Long taskId, Long commentId);

    CommentDto updateComment(Long projectId, Long taskId, Long commentId, CommentDto commentDto);

    void deleteCommentById(Long projectId, Long taskId, Long commentId);
}
