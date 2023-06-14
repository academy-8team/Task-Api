package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.request.TaskRequestDto;
import com.nhnacademy.task.dto.respond.TaskRespondDto;
import com.nhnacademy.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project/{projectNum}/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create/{memberNum}")
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto,
                                             BindingResult bindingResult,
                                             @PathVariable(value = "projectNum") Long projectNum,
                                             @PathVariable(value = "memberNum") Long memberNum) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed");
        }

        String result = taskService.createTask(taskRequestDto, projectNum);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{taskNum}")
    public ResponseEntity<TaskRespondDto> getTaskDetail(@PathVariable(value = "projectNum") Long projectNum,
                                                        @PathVariable(value = "taskNum") Long taskNum) {
        try {
            Optional<TaskRespondDto> task = taskService.findTaskDetail(projectNum, taskNum);
            return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (RuntimeException e) {
            // log exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping
    public ResponseEntity<List<TaskRespondDto>> getTaskAll(@PathVariable(value = "projectNum") Long projectNum) {

        List<TaskRespondDto> tasks = taskService.findTaskAll(projectNum);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/{taskNum}/update")
    public ResponseEntity<String> updateTask(@Valid @RequestBody TaskRequestDto taskRequestDto,
                                             BindingResult bindingResult,
                                             @PathVariable(value = "projectNum") Long projectNum,
                                             @PathVariable(value = "taskNum") Long taskNum) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Task 수정 Validation이 실패했습니다.");
        }

        String result = taskService.updateTask(taskRequestDto, projectNum, taskNum);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{taskNum}/delete")
    public ResponseEntity<String> deleteTask(@PathVariable(value = "projectNum") Long projectNum,
                                             @PathVariable(value = "taskNum") Long taskNum) {

        String result = taskService.deleteTask(projectNum, taskNum);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{taskNum}/milestone/{milestoneNum}/register")
    public ResponseEntity<String> registerMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                                    @PathVariable(value = "taskNum") Long taskNum,
                                                    @PathVariable(value = "milestoneNum") Long milestoneNum) {

        String result = taskService.registerMilestone(projectNum, taskNum, milestoneNum);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{taskNum}/tag/{tagNum}/taskTag/register")
    public ResponseEntity<String> registerTag(@PathVariable(value = "projectNum") Long projectNum,
                                              @PathVariable(value = "taskNum") Long taskNum,
                                              @PathVariable(value = "tagNum") Long tagNum) {

        String result = taskService.registerTag(projectNum, taskNum, tagNum);
        return ResponseEntity.ok(result);
    }
}
