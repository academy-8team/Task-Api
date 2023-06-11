/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : TaskNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class TaskNotFoundException extends RuntimeException {
    public static final String MESSAGE = "업무가 존재하지 않습니다.";
    public TaskNotFoundException() {
        super(MESSAGE);
    }
}

