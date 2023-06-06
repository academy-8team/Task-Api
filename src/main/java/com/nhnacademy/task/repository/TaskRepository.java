/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : TaskRepository
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.respond.TaskRespondDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    TaskRespondDto findByProjectAndTaskNum(Project project, Long taskNum);

    List<TaskRespondDto> findByProject(Project project);
}
