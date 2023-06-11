/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : TaskTagController
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.TaskTagDto;
import com.nhnacademy.task.service.TaskTagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects/{projectId}/tasks/{taskId}/tags")
@RequiredArgsConstructor
public class TaskTagController {

    private final TaskTagService taskTagService;

    @PostMapping("/{tagId}")
    public ResponseEntity<?> addTagToTask(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long tagId, @Valid @RequestBody TaskTagDto taskTagDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            return new ResponseEntity<>(taskTagService.addTagToTask(projectId, taskId, tagId, taskTagDto), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskTagDto>> getTagsForTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        try {
            return ResponseEntity.ok(taskTagService.getTagsForTask(projectId, taskId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<?> removeTagFromTask(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long tagId) {
        try {
            taskTagService.removeTagFromTask(projectId, taskId, tagId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
