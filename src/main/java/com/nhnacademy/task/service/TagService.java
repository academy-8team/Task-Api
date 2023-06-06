package com.nhnacademy.task.service;

import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    public Tag createTag(Long projectId, Tag tag) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        tag.setProject(project);
        return tagRepository.save(tag);
    }

    public Optional<Tag> getTags(Long projectId) {
        return tagRepository.findByProjectId(projectId);
    }

    public Tag getTag(Long projectId, Long tagId) {
        return tagRepository.findByIdAndProjectId(tagId, projectId)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    public Tag updateTag(Long projectId, Long tagId, Tag updatedTag) {
        Tag existingTag = getTag(projectId, tagId);
        existingTag.setName(updatedTag.getName());
        return tagRepository.save(existingTag);
    }

    public void deleteTag(Long projectId, Long tagId) {
        Tag tag = getTag(projectId, tagId);
        tagRepository.delete(tag);
    }
}
