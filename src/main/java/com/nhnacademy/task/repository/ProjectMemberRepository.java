/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : ProjectMemberRepository
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
import com.nhnacademy.task.entity.ProjectMember;
import com.nhnacademy.task.entity.pk.ProjectMemberPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberPk> {
    List<ProjectMember> findByProject(Project project);

    @Query("SELECT pm FROM ProjectMember pm WHERE pm.project = :project AND pm.projectMemberPk.projectMemberId = :projectMemberId")
    Optional<ProjectMember> findByProjectAndProjectMemberId(Project project, Long projectMemberId);
}
