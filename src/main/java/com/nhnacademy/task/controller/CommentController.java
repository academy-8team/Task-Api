/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : ConmmentController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.CommentRespondDto;
import com.nhnacademy.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // todo 8 - restful하게 api를 수정하고, 네이밍 규칙을 지킵니다. 또한, ResponseEntity와 @Valid, BindingResult를 사용합니다.
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/project/{projectNum}/task/{taskNum}/comment/register")
    public String registerComment(@PathVariable(value = "projectNum") Long projectNum,
                                  @PathVariable(value = "taskNum") Long taskNum,
                                  @RequestParam(value = "writerId") String writerId,
                                  @RequestParam(value = "commentContent") String commentContent) {
        return commentService.registerComment(commentContent, projectNum, taskNum, writerId);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/comment/all")
    public List<CommentRespondDto> getAllComment(
            @PathVariable(value = "projectNum") Long projectNum,
            @PathVariable(value = "taskNum") Long taskNum) {
        return commentService.getAllComment(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/comment/{commentNum}/update")
    public String updateComment(@RequestParam(value = "commentContent") String commentContent,
                                @PathVariable(value = "projectNum") Long projectNum,
                                @PathVariable(value = "taskNum") Long taskNum,
                                @PathVariable(value = "commentNum") Long commentNum) {
        return commentService.updateComment(commentContent, projectNum, taskNum, commentNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/comment/{commentNum}/delete")
    public String deleteComment(@PathVariable(value = "projectNum") Long projectNum,
                                @PathVariable(value = "taskNum") Long taskNum,
                                @PathVariable(value = "commentNum") Long commentNum) {
        return commentService.deleteComment(projectNum, taskNum, commentNum);
    }
}
