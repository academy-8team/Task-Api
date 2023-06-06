package com.nhnacademy.task.mapper;

import com.nhnacademy.task.entity.Tag;
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
