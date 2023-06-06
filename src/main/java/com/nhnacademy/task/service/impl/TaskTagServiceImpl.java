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

import com.nhnacademy.task.dto.response.TaskTagResponseDto;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.entity.TaskTag;
import com.nhnacademy.task.entity.pk.TaskTagPk;
import com.nhnacademy.task.repository.TagRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.repository.TaskTagRepository;
import com.nhnacademy.task.service.TaskTagService;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TaskTagServiceImpl implements TaskTagService {
    private final TaskTagRepository taskTagRepository;
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<String> getTaskTag(Long projectNum, Long taskNum) {
        Task task =  taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다"));

        List<TaskTagResponseDto> taskTags = taskTagRepository.findByTask(task);

        return taskTags.stream()
                .map(taskTagResponseDto -> taskTagResponseDto.getTag().getTagTitle())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String registerTaskTag(Long projectNum, Long taskNum, Long tagNum) {
        Task task = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다"));

        Tag tag = tagRepository.findById(tagNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 tag가 프로젝트 내에 존재하지 않습니다"));

        TaskTagPk taskTagPk = TaskTagPk.builder()
                .taskNum(taskNum)
                .tagNum(tagNum)
                .build();

        TaskTag taskTag = TaskTag.builder()
                .taskTagPk(taskTagPk)
                .task(task)
                .tag(tag)
                .build();

        taskTagRepository.save(taskTag);

        return "task tag가 등록되었습니다";
    }
}
