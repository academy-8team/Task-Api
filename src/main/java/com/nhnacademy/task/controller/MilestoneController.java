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

import com.nhnacademy.task.dto.MilestoneDto;
import com.nhnacademy.task.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/projects/{projectId}/milestones")
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity<MilestoneDto> createMilestone(@PathVariable Long projectId,
                                                        @Valid @RequestBody MilestoneDto milestoneDto,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(milestoneService.createMilestone(projectId, milestoneDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MilestoneDto>> getMilestones(@PathVariable Long projectId) {
        return new ResponseEntity<>(milestoneService.getMilestonesByProjectId(projectId), HttpStatus.OK);
    }

    @GetMapping("/{milestoneId}")
    public ResponseEntity<MilestoneDto> getMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {
        return new ResponseEntity<>(milestoneService.getMilestoneById(projectId, milestoneId), HttpStatus.OK);
    }

    @PutMapping("/{milestoneId}")
    public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable Long projectId,
                                                        @PathVariable Long milestoneId,
                                                        @Valid @RequestBody MilestoneDto milestoneDto,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(milestoneService.updateMilestone(projectId, milestoneId, milestoneDto), HttpStatus.OK);
    }

    @DeleteMapping("/{milestoneId}")
    public ResponseEntity<Void> deleteMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {
        milestoneService.deleteMilestoneById(projectId, milestoneId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
