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

import java.util.List;

import com.nhnacademy.task.dto.response.CommentResponseDto;
import com.nhnacademy.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/project/{projectNum}/task/{taskNum}/comment/register")
    public ResponseEntity<String> registerComment(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "taskNum") Long taskNum,
                                                  @RequestParam(value = "writerId") String writerId,
                                                  @RequestParam(value = "commentContent") String commentContent) {
        String result = commentService.registerComment(commentContent, projectNum, taskNum, writerId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/comment/all")
    public ResponseEntity<List<CommentResponseDto>> getAllComment(
            @PathVariable(value = "projectNum") Long projectNum,
            @PathVariable(value = "taskNum") Long taskNum) {
        List<CommentResponseDto> comments = commentService.getAllComment(projectNum, taskNum);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/project/{projectNum}/task/{taskNum}/comment/{commentNum}/update")
    public ResponseEntity<String> updateComment(@RequestParam(value = "commentContent") String commentContent,
                                                @PathVariable(value = "projectNum") Long projectNum,
                                                @PathVariable(value = "taskNum") Long taskNum,
                                                @PathVariable(value = "commentNum") Long commentNum) {
        String result = commentService.updateComment(commentContent, projectNum, taskNum, commentNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/project/{projectNum}/task/{taskNum}/comment/{commentNum}/delete")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "projectNum") Long projectNum,
                                                @PathVariable(value = "taskNum") Long taskNum,
                                                @PathVariable(value = "commentNum") Long commentNum) {
        String result = commentService.deleteComment(projectNum, taskNum, commentNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
