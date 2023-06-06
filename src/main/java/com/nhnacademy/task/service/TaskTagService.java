/**
 * packageName :  com.nhnacademy.task.service
 * fileName : TaskTagService
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

import java.util.List;

public interface TaskTagService {
    List<String> getTaskTag(Long projectNum, Long taskNum);

    String registerTaskTag(Long projectNum, Long taskNum, Long tagNum);
}
