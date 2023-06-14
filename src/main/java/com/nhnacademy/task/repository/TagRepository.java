package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.respond.TagRespondDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<TagRespondDto> findByProject(Project project);
}
