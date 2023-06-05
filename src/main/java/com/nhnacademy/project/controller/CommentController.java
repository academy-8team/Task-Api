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

package com.nhnacademy.project.controller;

import com.nhnacademy.project.dto.CommentDto;
import com.nhnacademy.project.dto.CreateUpdateCommentDto;
import com.nhnacademy.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects/{projectId}/tasks/{taskId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@PathVariable Long projectId, @PathVariable Long taskId, @RequestBody CreateUpdateCommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(taskId, commentDto));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(taskId, commentId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId, @RequestBody CreateUpdateCommentDto commentDto) {
        return ResponseEntity.ok(commentService.updateComment(taskId, commentId, commentDto));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long projectId, @PathVariable Long taskId, @PathVariable Long commentId) {
        commentService.deleteComment(taskId, commentId);
        return ResponseEntity.noContent().build();
    }
}