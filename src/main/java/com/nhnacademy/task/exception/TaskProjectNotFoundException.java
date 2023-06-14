/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : TaskProjectNotFoundException
 * author :  ichunghui
 * date : 2023/06/14
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/14                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class TaskProjectNotFoundException extends RuntimeException {
    public static final String MESSAGE = "프로젝트에서 태스크를 찾을 수 없습니다.";

    public TaskProjectNotFoundException() {
        super(MESSAGE);
    }
}

