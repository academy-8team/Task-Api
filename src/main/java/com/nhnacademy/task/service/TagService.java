/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TagService
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.TagDto;

import java.util.List;

public interface TagService {

    TagDto createTag(Long projectId, TagDto tagDto);

    List<TagDto> getTagsByProjectId(Long projectId);

    TagDto getTagById(Long projectId, Long tagId);

    void deleteTagById(Long projectId, Long tagId);

    TagDto updateTag(Long projectId, Long tagId, TagDto tagDto);
}

