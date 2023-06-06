/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : MilestoneController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.response.MilestoneResponseDto;

import java.util.List;

import com.nhnacademy.task.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MilestoneController {
    private final MilestoneService milestoneService;

    @PostMapping("/project/{projectNum}/milestone/create")
    public ResponseEntity<String> createMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                                  @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        String result = milestoneService.createMilestone(projectNum, milestoneTitle);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/project/{projectNum}/milestone")
    public ResponseEntity<List<MilestoneResponseDto>> findAllMilestone(@PathVariable(value = "projectNum") Long projectNum) {
        List<MilestoneResponseDto> milestones = milestoneService.findAllMilestone(projectNum);
        return new ResponseEntity<>(milestones, HttpStatus.OK);
    }

    @PutMapping("/project/{projectNum}/milestone/{milestoneNum}/register")
    public ResponseEntity<String> updateMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "milestoneNum") Long milestoneNum,
                                                  @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        String result = milestoneService.updateMilestone(projectNum, milestoneNum, milestoneTitle);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/project/{projectNum}/milestone/{milestoneNum}/delete")
    public ResponseEntity<String> deleteMilestone(@PathVariable(value = "projectNum") Long projectNum,
                                                  @PathVariable(value = "milestoneNum") Long milestoneNum) {
        String result = milestoneService.deleteMilestone(projectNum, milestoneNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/milestone/select")
    public ResponseEntity<List<MilestoneResponseDto>> getMilestoneByProjectNum(@PathVariable(value = "projectNum") Long projectNum,
                                                                               @PathVariable(value = "taskNum") Long taskNum) {
        List<MilestoneResponseDto> milestones = milestoneService.getMilestoneByProjectNum(projectNum, taskNum);
        return new ResponseEntity<>(milestones, HttpStatus.OK);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/milestone")
    public ResponseEntity<String> getMilestoneInTask(@PathVariable(value = "projectNum") Long projectNum,
                                                     @PathVariable(value = "taskNum") Long taskNum) {
        String result = milestoneService.getMilestoneByTaskNum(projectNum, taskNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
