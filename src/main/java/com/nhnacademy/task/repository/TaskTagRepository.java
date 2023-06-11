/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : TaskTagRepository
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.entity.TaskTag;
import com.nhnacademy.task.entity.pk.TaskTagPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTagPk> {

    Optional<TaskTag> findByTaskTagPk(TaskTagPk taskTagPk);

    List<TaskTag> findByTaskTagPkTaskIdAndTaskProjectId(Long taskId, Long projectId);
}
