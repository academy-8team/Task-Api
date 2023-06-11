/**
 * packageName :  com.nhnacademy.task.service.impl
 * fileName : TaskTagNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class TaskTagNotFoundException extends RuntimeException {
    public static final String MESSAGE = "프로젝트에 태그를 찾을 수 없습니다.";
    public TaskTagNotFoundException() {
        super(MESSAGE);
    }
}

