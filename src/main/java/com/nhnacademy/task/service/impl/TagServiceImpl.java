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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public String createTag(Long projectNum, String tagTitle) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        Tag tag = Tag.builder()
                .tagTitle(tagTitle)
                .project(project)
                .build();

        tagRepository.save(tag);

        return "tag가 저장되었습니다.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagResponseDto> findAllTag(Long projectNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        return tagRepository.findByProject(project);
    }

    @Override
    @Transactional
    public String updateTag(Long projectNum, Long tagNum, String tagTitle) {
        Tag updateTag = tagRepository.findById(tagNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 tag가 존재하지 않습니다."));

        updateTag.setTagTitle(tagTitle);
        tagRepository.save(updateTag);

        return "해당 태그가 수정되었습니다.";
    }

    @Override
    @Transactional
    public String deleteTag(Long projectNum, Long tagNum) {
        if (!tagRepository.existsById(tagNum)) {
            return "해당 태그가 존재하지 않습니다.";
        }

        tagRepository.deleteById(tagNum);

        return "해당 태그가 삭제되었습니다.";
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagResponseDto> getTagByProjectNum(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));
        return tagRepository.findByProject(project);
    }
}
