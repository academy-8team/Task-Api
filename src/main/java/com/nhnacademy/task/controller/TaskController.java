/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : TaskController
 * author :  ichunghui
 * date : 2023/06/02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */
package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.request.TaskRequestDto;
import com.nhnacademy.task.dto.respond.TaskRespondDto;
import com.nhnacademy.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController // todo 12 - restful하게 api를 수정하고, 네이밍 규칙을 지킵니다. 또한, ResponseEntity와 @Valid, BindingResult를 사용합니다.
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/project/{projectNum}/task/create/{memberNum}")
    public String createTask(@RequestBody TaskRequestDto taskRequestDto,
                             @PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "memberNum") Long memberNum) {

        return taskService.createTask(taskRequestDto, projectNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}")
    public Optional<TaskRespondDto> getTaskDetail(
            @PathVariable(value = "projectNum") Long projectNum,
            @PathVariable(value = "taskNum") Long taskNum) {
        return taskService.findTaskDetail(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task")
    public List<TaskRespondDto> getTaskAll(@PathVariable(value = "projectNum") Long projectNum) {
        return taskService.findTaskAll(projectNum);
    }

    @PostMapping("/project/{projectNum}/task/{taskNum}/update")
    public String updateTask(@RequestBody TaskRequestDto taskRequestDto,
                             @PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "taskNum") Long taskNum) {
        return taskService.updateTask(taskRequestDto, projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/delete")
    public String deleteTask(@PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "taskNum") Long taskNum) {
        return taskService.deleteTask(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/milestone/{milestoneNum}/register")
    public String registerMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                    @PathVariable(value = "taskNum") Long taskNum,
                                    @PathVariable(value = "milestoneNum") Long milestoneNum) {
        return taskService.registerMilestone(projectNum, taskNum, milestoneNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/tastTag/register")
    public String registerTag(@PathVariable(value = "projectNum") Long projectNum,
                              @PathVariable(value = "taskNum") Long taskNum,
                              @PathVariable(value = "tagNum") Long tagNum) {
        return taskService.registerTag(projectNum, taskNum, tagNum);
    }
}
