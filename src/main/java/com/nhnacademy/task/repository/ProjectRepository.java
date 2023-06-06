/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : ProjectRepository
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<com.nhnacademy.task.dto.respond.ProjectResponseDto> findAllBy(Pageable pageable);

    com.nhnacademy.task.dto.respond.ProjectResponseDto findByProjectNum(Long projectNum);
}
