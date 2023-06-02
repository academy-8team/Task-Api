package com.nhnacademy.project.repository;

import com.nhnacademy.project.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    List<Milestone> findByProjectId(Long projectId);
    Optional<Milestone> findByIdAndProjectId(Long id, Long projectId);
}
