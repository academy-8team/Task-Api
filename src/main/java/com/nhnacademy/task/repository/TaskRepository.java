/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : TaskRepository
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
    Optional<Task> findByProjectAndTaskId(Project project, Long taskId);
}

