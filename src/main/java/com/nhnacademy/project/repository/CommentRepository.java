package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByIdAndTaskId(Long id, Long taskId);

}
