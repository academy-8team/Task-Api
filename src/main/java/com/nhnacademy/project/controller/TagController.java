/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : TagController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.project.controller;

import com.nhnacademy.project.entity.Tag;
import com.nhnacademy.project.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects/{projectId}/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @PostMapping
    public ResponseEntity<Tag> createTag(@PathVariable Long projectId, @RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.createTag(projectId, tag));
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<Tag> getTag(@PathVariable Long projectId, @PathVariable Long tagId) {
        return ResponseEntity.ok(tagService.getTag(projectId, tagId));
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long projectId, @PathVariable Long tagId, @RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.updateTag(projectId, tagId, tag));
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long projectId, @PathVariable Long tagId) {
        tagService.deleteTag(projectId, tagId);
        return ResponseEntity.noContent().build();
    }
}


