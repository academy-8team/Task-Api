package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByIdAndProjectId(Long id, Long projectId);
}
