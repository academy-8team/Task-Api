/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : TaskNotFoundExpceion
 * author :  ichunghui
 * date : 2023/06/14 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/14                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class TaskNotFoundExpceion extends RuntimeException {
    public static final String MESSAGE = "태스크를 찾을 수 없습니다.";
    public TaskNotFoundExpceion() {
        super(MESSAGE);
    }
}

