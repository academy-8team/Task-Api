package com.nhnacademy.task.service;

import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.mapper.CommentMapper;
import com.nhnacademy.task.repository.CommentRepository;
import com.nhnacademy.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final CommentMapper commentMapper;

    public CommentDto createComment(Long taskId, CreateUpdateCommentDto commentDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        Comment comment = commentMapper.toEntity(commentDto, task);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }


    public CommentDto getComment(Long taskId, Long commentId) {
        Comment comment = commentRepository.findByIdAndTaskId(commentId, taskId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return commentMapper.toDto(comment);
    }

    public CommentDto updateComment(Long taskId, Long commentId, CreateUpdateCommentDto commentDto) {
        Comment existingComment = getCommentEntity(taskId, commentId);
        existingComment.setContent(commentDto.getContent());
        Comment updatedComment = commentRepository.save(existingComment);
        return commentMapper.toDto(updatedComment);
    }


    public void deleteComment(Long taskId, Long commentId) {
        Comment comment = getCommentEntity(taskId, commentId);
        commentRepository.delete(comment);
    }

    private Comment getCommentEntity(Long taskId, Long commentId) {
        return commentRepository.findByIdAndTaskId(commentId, taskId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}