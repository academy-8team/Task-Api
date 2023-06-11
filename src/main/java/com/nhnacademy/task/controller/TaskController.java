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

import com.nhnacademy.task.dto.TaskDto;
import com.nhnacademy.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@PathVariable Long projectId, @Valid @RequestBody TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.createTask(projectId, taskDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks(@PathVariable Long projectId) {
        return new ResponseEntity<>(taskService.getTasksByProjectId(projectId), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.getTaskById(projectId, taskId), HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable Long projectId, @PathVariable Long taskId, @Valid @RequestBody TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskService.updateTask(projectId, taskId, taskDto), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        taskService.deleteTaskById(projectId, taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
