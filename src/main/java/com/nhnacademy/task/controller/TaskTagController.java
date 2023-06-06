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

import com.nhnacademy.task.service.TaskTagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TaskTagController {
    private final TaskTagService taskTagService;

    @GetMapping("/project/{projectNum}/task/{taskNum}/taskTag")
    public ResponseEntity<List<String>> getTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                                   @PathVariable(value = "taskNum") Long taskNum) {
        List<String> tags = taskTagService.getTaskTag(projectNum, taskNum);
        return ResponseEntity.ok().body(tags);
    }

    @PostMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/taskTag/register")
    public ResponseEntity<String> registerTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "taskNum") Long taskNum,
                                                  @PathVariable(value = "tagNum") Long tagNum) {
        String result = taskTagService.registerTaskTag(projectNum, taskNum, tagNum);
        return ResponseEntity.ok().body(result);
    }
}
