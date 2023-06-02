package com.nhnacademy.project.mapper;

import com.nhnacademy.project.dto.CreateUpdateTagDto;
import com.nhnacademy.project.dto.TagDto;
import com.nhnacademy.project.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {
    public TagDto toDto(Tag tag) {
        TagDto dto = new TagDto();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }

    public Tag toEntity(CreateUpdateTagDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tag;
    }
}
