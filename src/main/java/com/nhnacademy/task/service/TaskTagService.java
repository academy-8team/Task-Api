/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TaskTagService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;


import com.nhnacademy.task.dto.TaskTagDto;

import java.util.List;

public interface TaskTagService {

    TaskTagDto addTagToTask(Long projectId, Long taskId, Long tagId, TaskTagDto taskTagDto);

    List<TaskTagDto> getTagsForTask(Long projectId, Long taskId);

    void removeTagFromTask(Long projectId, Long taskId, Long tagId);
}
