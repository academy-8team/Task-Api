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

package com.nhnacademy.project.controller;

import com.nhnacademy.project.dto.CreateUpdateMilestoneDto;
import com.nhnacademy.project.dto.MilestoneDto;
import com.nhnacademy.project.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects/{projectId}/milestones")
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity<MilestoneDto> createMilestone(@PathVariable Long projectId, @RequestBody CreateUpdateMilestoneDto milestoneDto) {
        return ResponseEntity.ok(milestoneService.createMilestone(projectId, milestoneDto));
    }

    @GetMapping("/{milestoneId}")
    public ResponseEntity<MilestoneDto> getMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {
        return ResponseEntity.ok(milestoneService.getMilestone(projectId, milestoneId));
    }

    @PutMapping("/{milestoneId}")
    public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId, @RequestBody CreateUpdateMilestoneDto milestoneDto) {
        return ResponseEntity.ok(milestoneService.updateMilestone(projectId, milestoneId, milestoneDto));
    }

    @DeleteMapping("/{milestoneId}")
    public ResponseEntity<Void> deleteMilestone(@PathVariable Long projectId, @PathVariable Long milestoneId) {
        milestoneService.deleteMilestone(projectId, milestoneId);
        return ResponseEntity.noContent().build();
    }
}

