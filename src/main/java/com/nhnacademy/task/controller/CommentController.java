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

import com.nhnacademy.task.dto.CommentDto;
import com.nhnacademy.task.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(@PathVariable Long projectId, @PathVariable Long taskId, @Valid @RequestBody CommentDto commentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(commentService.createComment(projectId, taskId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long projectId, @PathVariable Long taskId) {
        return new ResponseEntity<>(commentService.getCommentsByTaskId(projectId, taskId), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(projectId, taskId, commentId), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, @Valid @RequestBody CommentDto commentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(commentService.updateComment(projectId, taskId, commentId, commentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId) {
        commentService.deleteCommentById(projectId, taskId, commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
