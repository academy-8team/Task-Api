package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.CommentRespondDto;
import com.nhnacademy.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project/{projectNum}/task/{taskNum}/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/register")
    public ResponseEntity<String> registerComment(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "taskNum") Long taskNum,
                                                  @RequestParam(value = "writerId") String writerId,
                                                  @RequestParam(value = "commentContent") String commentContent) {

        String message = commentService.registerComment(commentContent, projectNum, taskNum, writerId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentRespondDto>> getAllComment(@PathVariable(value = "projectNum") Long projectNum,
                                                                 @PathVariable(value = "taskNum") Long taskNum) {

        List<CommentRespondDto> comments = commentService.getAllComment(projectNum, taskNum);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{commentNum}/update")
    public ResponseEntity<String> updateComment(@RequestParam(value = "commentContent") String commentContent,
                                                @PathVariable(value = "projectNum") Long projectNum,
                                                @PathVariable(value = "taskNum") Long taskNum,
                                                @PathVariable(value = "commentNum") Long commentNum) {

        String message = commentService.updateComment(commentContent, projectNum, taskNum, commentNum);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{commentNum}/delete")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "projectNum") Long projectNum,
                                                @PathVariable(value = "taskNum") Long taskNum,
                                                @PathVariable(value = "commentNum") Long commentNum) {

        String message = commentService.deleteComment(projectNum, taskNum, commentNum);
        return ResponseEntity.ok(message);
    }
}
