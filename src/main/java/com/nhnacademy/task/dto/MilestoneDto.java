/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : MilestoneDto
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.Milestone;
import com.nhnacademy.task.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneDto {

    private Long milestoneId;
    private String milestoneTitle;

    public Milestone toEntity(Project project) {
        return Milestone.builder()
                .project(project)
                .milestoneTitle(this.milestoneTitle)
                .build();
    }

    public static MilestoneDto fromEntity(Milestone milestone) {
        return new MilestoneDto(milestone.getMilestoneId(), milestone.getMilestoneTitle());
    }
}
