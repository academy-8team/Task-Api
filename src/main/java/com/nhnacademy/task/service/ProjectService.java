/**
 * packageName :  com.nhnacademy.task.service
 * fileName : ProjectService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.request.ProjectRequestDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<com.nhnacademy.task.dto.respond.ProjectResponseDto> getProjects(int page);

    Optional<com.nhnacademy.task.dto.respond.ProjectResponseDto> makeProject(
            ProjectRequestDto projectRequestDto, Long memberNum);

    Optional<com.nhnacademy.task.dto.respond.ProjectResponseDto> getProjectByProjectNum(Long projectNum);
}
