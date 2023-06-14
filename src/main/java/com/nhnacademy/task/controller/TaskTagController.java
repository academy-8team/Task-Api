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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController // todo 13 - restful하게 api를 수정하고, 네이밍 규칙을 지킵니다. 또한, ResponseEntity와 @Valid, BindingResult를 사용합니다.
public class TaskTagController {
    private final TaskTagService taskTagService;

    @GetMapping("/project/{projectNum}/task/{taskNum}/taskTag")
    public List<String> getTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                   @PathVariable(value = "taskNum") Long taskNum) {
        return taskTagService.getTaskTag(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/taskTag/register")
    public String registerTaskTag(@PathVariable(value = "projectNum") Long projectNum,
                                  @PathVariable(value = "taskNum") Long taskNum,
                                  @PathVariable(value = "tagNum") Long tagNum) {
        return taskTagService.registerTaskTag(projectNum, taskNum, tagNum);
    }
}
