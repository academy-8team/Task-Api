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

import com.nhnacademy.task.dto.respond.MilestoneRespondDto;
import com.nhnacademy.task.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController // todo 9 - restful하게 api를 수정하고, 네이밍 규칙을 지킵니다. 또한, ResponseEntity와 @Valid, BindingResult를 사용합니다.
public class MilestoneController {
    private final MilestoneService milestoneService;

    @GetMapping("/project/{projectNum}/milestone/create")
    public String createTag(@PathVariable(value = "projectNum") Long projectNum,
                            @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        return milestoneService.createMilestone(projectNum, milestoneTitle);
    }

    @GetMapping("/project/{projectNum}/milestone")
    public List<MilestoneRespondDto> findAllTag(@PathVariable(value = "projectNum") Long projectNum) {
        return milestoneService.findAllMilestone(projectNum);
    }

    @GetMapping("/project/{projectNum}/milestone/{milestoneNum}/register")
    public String updateTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "milestoneNum") Long milestoneNum,
                            @RequestParam(value = "milestoneTitle") String milestoneTitle) {
        return milestoneService.updateTag(projectNum, milestoneNum, milestoneTitle);
    }

    @GetMapping("/project/{projectNum}/milestone/{milestoneNum}/delete")
    public String deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "milestoneNum") Long milestoneNum) {
        return milestoneService.deleteTag(projectNum, milestoneNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/milestone/select")
    public List<MilestoneRespondDto> getTagByProjectNum(@PathVariable(value = "projectNum") Long projectNum,
                                                        @PathVariable(value = "taskNum") Long taskNum) {
        return milestoneService.getMilestoneByProjectNum(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/milestone")
    public String getMilestoneInTask(@PathVariable(value = "projectNum") Long projectNum,
                                     @PathVariable(value = "taskNum") Long taskNum) {
        return milestoneService.getMilestoneByTaskNum(projectNum, taskNum);
    }
}
