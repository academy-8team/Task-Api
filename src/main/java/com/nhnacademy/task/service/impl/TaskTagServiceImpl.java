/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : TaskTagServiceImpl
 * author :  ichunghui
 * date : 2023/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.TaskTagDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.entity.TaskTag;
import com.nhnacademy.task.entity.pk.TaskTagPk;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.exception.TagNotFoundException;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.exception.TaskTagNotFoundException;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TagRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.repository.TaskTagRepository;
import com.nhnacademy.task.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskTagServiceImpl implements TaskTagService {

    private final TaskTagRepository taskTagRepository;
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Override
    public TaskTagDto addTagToTask(Long projectId, Long taskId, Long tagId, TaskTagDto taskTagDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(TagNotFoundException::new);

        TaskTag taskTag = TaskTag.builder()
                .taskTagPk(new TaskTagPk(tagId, taskId))
                .tag(tag)
                .task(task)
                .build();

        taskTagRepository.save(taskTag);

        return TaskTagDto.fromEntity(taskTag);
    }

    @Override
    public List<TaskTagDto> getTagsForTask(Long projectId, Long taskId) {
        return taskTagRepository. findByTaskTagPkTaskIdAndTaskProjectId(taskId, projectId).stream()
                .map(TaskTagDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void removeTagFromTask(Long projectId, Long taskId, Long tagId) {
        TaskTag taskTag = taskTagRepository.findByTaskTagPk(new TaskTagPk(tagId, taskId))
                .orElseThrow(TagNotFoundException::new);
        taskTagRepository.delete(taskTag);
    }
}
