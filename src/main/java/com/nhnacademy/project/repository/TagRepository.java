package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByIdAndProjectId(Long id, Long projectId);
    Optional<Tag> findByProjectId(Long projectId);
}
