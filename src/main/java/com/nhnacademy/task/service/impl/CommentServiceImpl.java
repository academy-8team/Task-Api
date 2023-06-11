/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : CommentServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.response.CommentResponseDto;
import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.repository.CommentRepository;
import com.nhnacademy.task.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public String registerComment(@RequestBody String commentContent, Long projectNum, Long taskNum,
                                  String writerId) {
        Task task = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .commentContent(commentContent)
                .task(task)
                .writerId(writerId)
                .build();

        commentRepository.save(comment);

        return "댓글이 저장 되었습니다.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getAllComment(Long projectNum, Long taskNum) {
        Task task = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다."));

        return commentRepository.findByTask(task);
    }

    @Override
    @Transactional
    public String updateComment(String commentContent, Long projectNum, Long taskNum,
                                Long commentNum) {
        Comment updateComment = commentRepository.findById(commentNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 comment가 존재하지 않습니다."));

        updateComment.setCommentContent(commentContent);

        commentRepository.save(updateComment);

        return "comment가 수정되었습니다.";
    }

    @Override
    @Transactional
    public String deleteComment(Long projectNum, Long taskNum, Long commentNum) {
        if (!commentRepository.existsById(commentNum)) {
            return "해당 comment가 존재하지 않습니다.";
        }

        commentRepository.deleteById(commentNum);

        return "comment가 삭제되었습니다.";
    }
}
