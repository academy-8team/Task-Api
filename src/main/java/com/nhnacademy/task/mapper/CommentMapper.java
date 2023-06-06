package com.nhnacademy.task.mapper;

import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {


    public CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setTaskId(comment.getTask().getId());
        return commentDto;
    }

    public Comment toEntity(CreateUpdateCommentDto commentDto, Task task) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setTask(task);
        return comment;
    }
}