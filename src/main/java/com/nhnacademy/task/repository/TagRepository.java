/**
 * packageName :  com.nhnacademy.task.repository
 * fileName : TagRepository
 * author :  ichunghui
 * date : 2023/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.response.TagResponseDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Tag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<TagResponseDto> findByProject(Project project);
}
