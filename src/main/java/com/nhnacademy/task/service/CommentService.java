/**
 * packageName :  com.nhnacademy.task.service
 * fileName : CommentService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.CommentRespondDto;
import java.util.List;

public interface CommentService {
    String registerComment(String commentContent, Long projectNum, Long taskNum, String wrtierId);

    List<CommentRespondDto> getAllComment(Long projectNum, Long taskNum);

    String updateComment(String commentContent, Long projectNum, Long taskNum, Long commentNum);

    String deleteComment(Long projectNum, Long taskNum, Long commentNum);
}
