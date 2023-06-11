/**
 * packageName :  com.nhnacademy.task.dto
 * fileName : TagDto
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.dto;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    private Long tagId;
    private String tagTitle;

    public Tag toEntity(Project project) {
        return Tag.builder()
                .project(project)
                .tagTitle(this.tagTitle)
                .build();
    }

    public static TagDto fromEntity(Tag tag) {
        return new TagDto(tag.getTagId(), tag.getTagTitle());
    }
}

