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

package com.nhnacademy.project.controller;

import com.nhnacademy.project.entity.Task;
import com.nhnacademy.project.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects/{projectId}/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(projectId, task));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getTask(projectId, taskId));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long projectId, @PathVariable Long taskId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(projectId, taskId, task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        taskService.deleteTask(projectId, taskId);
        return ResponseEntity.noContent().build();
    }
}


