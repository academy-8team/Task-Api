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

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.response.TagResponseDto;

import java.util.List;

import com.nhnacademy.task.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TagController {
    private final TagService tagService;

    @PostMapping("/project/{projectNum}/tasks/{taskNum}/tags")
    public ResponseEntity<String> createTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @RequestParam(value = "tagTitle") String tagTitle) {
        String result = tagService.createTag(projectNum, tagTitle);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/project/{projectNum}/tag")
    public ResponseEntity<List<TagResponseDto>> findAllTag(@PathVariable(value = "projectNum") Long projectNum) {
        List<TagResponseDto> tags = tagService.findAllTag(projectNum);
        return ResponseEntity.ok().body(tags);
    }

    @PutMapping("/project/{projectNum}/tag/{tagNum}/register")
    public ResponseEntity<String> updateTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @PathVariable(value = "tagNum") Long tagNum,
                                            @RequestParam(value = "tagTitle") String tagTitle) {
        String result = tagService.updateTag(projectNum, tagNum, tagTitle);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/project/{projectNum}/tag/{tagNum}/delete")
    public ResponseEntity<String> deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @PathVariable(value = "tagNum") Long tagNum) {
        String result = tagService.deleteTag(projectNum, tagNum);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/select")
    public ResponseEntity<List<TagResponseDto>> getTagByProjectNum(@PathVariable(value = "projectNum") Long projectNum,
                                                                   @PathVariable(value = "taskNum") Long taskNum) {
        List<TagResponseDto> tags = tagService.getTagByProjectNum(projectNum, taskNum);
        return ResponseEntity.ok().body(tags);
    }
}
