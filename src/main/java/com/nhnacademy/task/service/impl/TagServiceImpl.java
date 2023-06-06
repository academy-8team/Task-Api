/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : TagServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.response.TagResponseDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TagRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.TagService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Override
    public String createTag(Long projectNum, String tagTitle) {
        Optional<Project> project = projectRepository.findById(projectNum);

        if (project.isEmpty()) {
            return "해당 프로젝트가 존재하지 않습니다.";
        }

        Tag tag = Tag.builder()
                .tagTitle(tagTitle)
                .project(project.get())
                .build();

        tagRepository.save(tag);

        return "tag가 저장되었습니다.";
    }

    @Override
    public List<TagResponseDto> findAllTag(Long projectNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new RuntimeException("해당 프로젝트가 존재하지 않습니다."));
        return tagRepository.findByProject(project);
    }

    @Override
    public String updateTag(Long projectNum, Long tagNum, String tagTitle) {
        Optional<Tag> tag = tagRepository.findById(tagNum);

        if (tag.isEmpty()) {
            return "해당 tag가 존재하지 않습니다.";
        }

        Tag updateTag = tag.get();
        updateTag.setTagTitle(tagTitle);

        tagRepository.save(updateTag);

        return "해당 태그가 수정되었습니다.";
    }

    @Override
    public String deleteTag(Long projectNum, Long tagNum) {
        tagRepository.deleteById(tagNum);

        return "해당 태그가 삭제되었습니다.";
    }

    @Override
    public List<TagResponseDto> getTagByProjectNum(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new RuntimeException("해당 프로젝트가 존재하지 않습니다."));
        return tagRepository.findByProject(project);
    }
}
