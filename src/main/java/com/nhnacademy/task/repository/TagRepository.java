/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : TagRepository
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.TagDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByProject(Project project);

    @Query("SELECT t FROM Tag t WHERE t.project.id = :projectId AND t.tagId = :tagId")
    Optional<Tag> findByProjectIdAndTagId(Long projectId, Long tagId);
}



