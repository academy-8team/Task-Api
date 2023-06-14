package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.respond.CommentRespondDto;
import com.nhnacademy.task.entity.Comment;
import com.nhnacademy.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentRespondDto> findByTask(Task task);
}
