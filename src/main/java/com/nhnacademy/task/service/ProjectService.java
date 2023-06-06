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
import com.nhnacademy.task.dto.response.ProjectResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectResponseDto> getProjects(int page);

    Optional<ProjectResponseDto> makeProject(
            ProjectRequestDto projectRequestDto, Long memberNum);

    Optional<ProjectResponseDto> getProjectByProjectNum(Long projectNum);
}
