/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : MilestoneRepository
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    List<com.nhnacademy.task.dto.respond.MilestoneResponseDto> findByProject(Project project);
}
