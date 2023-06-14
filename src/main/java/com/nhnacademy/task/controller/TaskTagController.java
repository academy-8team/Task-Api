package com.nhnacademy.task.controller;

import com.nhnacademy.task.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project/{projectNum}/task/{taskNum}/taskTag")
public class TaskTagController {

    private final TaskTagService taskTagService;

    @GetMapping
    public ResponseEntity<List<String>> getTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                                   @PathVariable(value = "taskNum") Long taskNum) {
        List<String> taskTags = taskTagService.getTaskTag(projectNum, taskNum);
        return ResponseEntity.ok(taskTags);
    }

    @PostMapping("/tag/{tagNum}/register")
    public ResponseEntity<String> registerTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "taskNum") Long taskNum,
                                                  @PathVariable(value = "tagNum") Long tagNum) {
        String result = taskTagService.registerTaskTag(projectNum, taskNum, tagNum);
        return ResponseEntity.ok(result);
    }
}
