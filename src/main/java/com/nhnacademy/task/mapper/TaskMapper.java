/**
 * packageName :  com.nhnacademy.project.mapper
 * fileName : TaskMapper
 * author :  ichunghui
 * date : 2023/06/02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.task.mapper;

import com.nhnacademy.task.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public ProjectDto toDto(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setStatus(String.valueOf(project.getStatus()));
        return dto;
    }

    public Project toEntity(CreateUpdateTaskDto dto) {
        Project project = new Project();
        project.setName(dto.getContent());
        return project;
    }
}

