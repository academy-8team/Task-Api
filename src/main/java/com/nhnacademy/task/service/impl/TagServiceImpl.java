package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.TagDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.exception.ProjectNotFoundException;
import com.nhnacademy.task.exception.TagNotFoundException;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TagRepository;
import com.nhnacademy.task.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Override
    public TagDto createTag(Long projectId, TagDto tagDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        Tag tag = tagDto.toEntity(project);
        return TagDto.fromEntity(tagRepository.save(tag));
    }

    @Override
    public List<TagDto> getTagsByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + projectId + " not found"));
        List<TagDto> collect = tagRepository.findByProject(project).stream()
                .map(TagDto::fromEntity)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public TagDto getTagById(Long projectId, Long tagId) {
        Tag tag = tagRepository.findByProjectIdAndTagId(projectId, tagId)
                .orElseThrow(TagNotFoundException::new);
        return TagDto.fromEntity(tag);
    }

    @Override
    public void deleteTagById(Long projectId, Long tagId) {
        Tag tag = tagRepository.findByProjectIdAndTagId(projectId, tagId)
                .orElseThrow(TagNotFoundException::new);
        tagRepository.delete(tag);
    }

    @Override
    public TagDto updateTag(Long projectId, Long tagId, TagDto tagDto) {
        Tag tag = tagRepository.findByProjectIdAndTagId(projectId, tagId)
                .orElseThrow(TagNotFoundException::new);
        tag.update(tagDto.getTagTitle());
        return TagDto.fromEntity(tagRepository.save(tag));
    }
}
