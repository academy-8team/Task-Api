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

import com.nhnacademy.task.dto.CommentDto;
import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.exception.CommentNotFoundException;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.CommentRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentDto createComment(Long projectId, Long taskId, CommentDto commentDto) {
        Task task = getTask(projectId, taskId);
        Comment comment = commentDto.toEntity(task);
        return CommentDto.fromEntity(commentRepository.save(comment));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentDto> getCommentsByTaskId(Long projectId, Long taskId) {
        Task task = getTask(projectId, taskId);
        return commentRepository.findByTask(task).stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public CommentDto getCommentById(Long projectId, Long taskId, Long commentId) {
        Task task = getTask(projectId, taskId);
        Comment comment = commentRepository.findByTaskAndCommentId(task, commentId)
                .orElseThrow(CommentNotFoundException::new);
        return CommentDto.fromEntity(comment);
    }

    @Override
    public CommentDto updateComment(Long projectId, Long taskId, Long commentId, CommentDto commentDto) {
        Task task = getTask(projectId, taskId);
        Comment comment = commentRepository.findByTaskAndCommentId(task, commentId)
                .orElseThrow(CommentNotFoundException::new);
        comment.updateContent(commentDto.getCommentContent());
        commentRepository.save(comment);
        return CommentDto.fromEntity(comment);
    }

    @Override
    public void deleteCommentById(Long projectId, Long taskId, Long commentId) {
        Task task = getTask(projectId, taskId);
        Comment comment = commentRepository.findByTaskAndCommentId(task, commentId)
                .orElseThrow(CommentNotFoundException::new);
        commentRepository.delete(comment);
    }

    private Task getTask(Long projectId, Long taskId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFoundException::new);
        return taskRepository.findByProjectAndTaskId(project, taskId)
                .orElseThrow(TaskNotFoundException::new);
    }
}
