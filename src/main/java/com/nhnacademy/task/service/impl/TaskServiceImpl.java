/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : TaskServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.request.TaskRequestDto;
import com.nhnacademy.task.dto.response.TaskResponseDto;
import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.entity.TaskTag;
import com.nhnacademy.task.entity.pk.TaskTagPk;
import com.nhnacademy.task.repository.MilestoneRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.repository.TaskTagRepository;
import com.nhnacademy.task.service.TaskService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;
    private final TagRepository tagRepository;
    private final TaskTagRepository taskTagRepository;

    @Override
    @Transactional
    public String createTask(TaskRequestDto taskRequestDto,
                             Long projectNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        Task task = Task.builder()
                .project(project)
                .taskTitle(taskRequestDto.getTaskTitle())
                .taskContent(taskRequestDto.getTaskContent())
                .build();

        taskRepository.save(task);

        return "태스크가 저장되었습니다.";
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TaskResponseDto> findTaskDetail(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        TaskResponseDto taskResponseDto =
                taskRepository.findByProjectAndTaskNum(project, taskNum);

        return Optional.ofNullable(taskResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskResponseDto> findTaskAll(Long projectNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        return taskRepository.findByProject(project);
    }

    @Override
    @Transactional
    public String updateTask(TaskRequestDto taskRequestDto, Long projectNum, Long taskNum) {
        Task updateTask = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다."));

        updateTask.setTaskTitle(taskRequestDto.getTaskTitle());
        updateTask.setTaskContent(taskRequestDto.getTaskContent());

        taskRepository.save(updateTask);

        return "task가 수정되었습니다.";
    }

    @Override
    @Transactional
    public String deleteTask(Long projectNum, Long taskNum) {
        if (!taskRepository.existsById(taskNum)) {
            return "해당 task가 존재하지 않습니다.";
        }

        taskRepository.deleteById(taskNum);

        return "task가 삭제되었습니다.";
    }

    @Override
    @Transactional
    public String registerMilestone(Long projectNum, Long taskNum, Long milestoneNum) {
        Task updateTask = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다"));

        Milestone milestone = milestoneRepository.findById(milestoneNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 마일스톤이 존재하지 않습니다"));

        updateTask.setMilestone(milestone);

        taskRepository.save(updateTask);

        return "해당 task에 마일스톤을 등록하였습니다.";
    }

    @Override
    @Transactional
    public String registerTag(Long projectNum, Long taskNum, Long tagNum) {
        Task updateTask = taskRepository.findById(taskNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 task가 존재하지 않습니다"));

        Tag tag = tagRepository.findById(tagNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 tag가 프로젝트 내에 존재하지 않습니다"));

        TaskTagPk taskTagPk = TaskTagPk.builder()
                .taskNum(taskNum)
                .tagNum(tagNum)
                .build();

        TaskTag taskTag = TaskTag.builder()
                .taskTagPk(taskTagPk)
                .task(updateTask)
                .tag(tag)
                .build();

        taskTagRepository.save(taskTag);

        return "task의 tag가 등록되었습니다";
    }
}
