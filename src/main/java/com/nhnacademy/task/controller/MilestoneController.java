package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.MilestoneRespondDto;
import com.nhnacademy.task.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project/{projectNum}/milestone")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/create")
    public ResponseEntity<String> createTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        String result = milestoneService.createMilestone(projectNum, milestoneTitle);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<MilestoneRespondDto>> findAllTag(@PathVariable(value = "projectNum") Long projectNum) {
        List<MilestoneRespondDto> milestones = milestoneService.findAllMilestone(projectNum);
        return ResponseEntity.ok(milestones);
    }

    @GetMapping("/{milestoneNum}/register")
    public ResponseEntity<String> updateTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @PathVariable(value = "milestoneNum") Long milestoneNum,
                                            @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        String result = milestoneService.updateTag(projectNum, milestoneNum, milestoneTitle);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{milestoneNum}/delete")
    public ResponseEntity<String> deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                                            @PathVariable(value = "milestoneNum") Long milestoneNum) {
        String result = milestoneService.deleteTag(projectNum, milestoneNum);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/task/{taskNum}/select")
    public ResponseEntity<List<MilestoneRespondDto>> getTagByProjectNum(@PathVariable(value = "projectNum") Long projectNum,
                                                                        @PathVariable(value = "taskNum") Long taskNum) {
        List<MilestoneRespondDto> milestones = milestoneService.getMilestoneByProjectNum(projectNum, taskNum);
        return ResponseEntity.ok(milestones);
    }

    @GetMapping("/task/{taskNum}")
    public ResponseEntity<String> getMilestoneInTask(@PathVariable(value = "projectNum") Long projectNum,
                                                     @PathVariable(value = "taskNum") Long taskNum) {
        String result = milestoneService.getMilestoneByTaskNum(projectNum, taskNum);
        return ResponseEntity.ok(result);
    }
}
