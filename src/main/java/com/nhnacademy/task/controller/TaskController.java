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

import com.nhnacademy.task.dto.response.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/project/{projectNum}/task")
    public ResponseEntity<String> createTask(@RequestBody TaskRequestDto taskRequestDto,
                                             @PathVariable(value = "projectNum") Long projectNum) {

        String result = taskService.createTask(taskRequestDto, projectNum);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}")
    public ResponseEntity<Optional<TaskResponseDto>> getTaskDetail(
            @PathVariable(value = "projectNum") Long projectNum,
            @PathVariable(value = "taskNum") Long taskNum) {
        Optional<TaskResponseDto> task = taskService.findTaskDetail(projectNum, taskNum);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/project/{projectNum}/task")
    public ResponseEntity<List<TaskResponseDto>> getTaskAll(@PathVariable(value = "projectNum") Long projectNum) {
        List<TaskResponseDto> tasks = taskService.findTaskAll(projectNum);
        return ResponseEntity.ok().body(tasks);
    }

    @PutMapping("/project/{projectNum}/task/{taskNum}")
    public ResponseEntity<String> updateTask(@RequestBody TaskRequestDto taskRequestDto,
                                             @PathVariable(value = "projectNum") Long projectNum,
                                             @PathVariable(value = "taskNum") Long taskNum) {
        String result = taskService.updateTask(taskRequestDto, projectNum, taskNum);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/project/{projectNum}/task/{taskNum}/delete")
    public ResponseEntity<String> deleteTask(@PathVariable(value = "projectNum") Long projectNum,
                                             @PathVariable(value = "taskNum") Long taskNum) {
        String result = taskService.deleteTask(projectNum, taskNum);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/project/{projectNum}/task/{taskNum}/milestone/{milestoneNum}")
    public ResponseEntity<String> registerMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                                    @PathVariable(value = "taskNum") Long taskNum,
                                                    @PathVariable(value = "milestoneNum") Long milestoneNum) {
        String result = taskService.registerMilestone(projectNum, taskNum, milestoneNum);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/tastTag/register")
    public ResponseEntity<String> registerTag(@PathVariable(value = "projectNum") Long projectNum,
                                              @PathVariable(value = "taskNum") Long taskNum,
                                              @PathVariable(value = "tagNum") Long tagNum) {
        String result = taskService.registerTag(projectNum, taskNum, tagNum);
        return ResponseEntity.ok().body(result);
    }
}
