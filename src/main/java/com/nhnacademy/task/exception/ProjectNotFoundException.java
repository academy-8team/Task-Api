/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : ProjectNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class ProjectNotFoundException extends RuntimeException {
    public static final String MESSAGE = "프로젝트를 찾을 수 없습니다.";
    public ProjectNotFoundException() {
        super(MESSAGE);
    }
}

