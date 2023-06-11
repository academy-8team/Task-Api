/**
 * packageName :  com.nhnacademy.task.controller
 * fileName : TagController
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.TagDto;
import com.nhnacademy.task.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects/{projectId}/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<?> createTag(@PathVariable Long projectId, @Valid @RequestBody TagDto tagDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tagService.createTag(projectId, tagDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getTags(@PathVariable Long projectId) {
        return new ResponseEntity<>(tagService.getTagsByProjectId(projectId), HttpStatus.OK);
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTag(@PathVariable Long projectId, @PathVariable Long tagId) {
        return new ResponseEntity<>(tagService.getTagById(projectId, tagId), HttpStatus.OK);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long projectId, @PathVariable Long tagId) {
        tagService.deleteTagById(projectId, tagId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<?> updateTag(@PathVariable Long projectId, @PathVariable Long tagId, @Valid @RequestBody TagDto tagDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tagService.updateTag(projectId, tagId, tagDto), HttpStatus.OK);
    }
}
