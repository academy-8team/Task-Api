/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TagService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.TagRespondDto;
import java.util.List;

public interface TagService {
    String createTag(Long projectNum, String tagTitle);

    List<TagRespondDto> findAllTag(Long projectNum);

    String updateTag(Long projectNum, Long tagNum, String tagTitle);

    String deleteTag(Long projectNum, Long tagNum);

    List<TagRespondDto> getTagByProjectNum(Long projectNum, Long taskNum);
}
