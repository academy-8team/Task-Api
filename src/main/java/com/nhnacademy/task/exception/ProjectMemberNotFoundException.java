/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : ProjectMemberNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class ProjectMemberNotFoundException extends RuntimeException {
    public static final String MESSAGE = "프로젝트 멤버를 찾을 수 없습니다.";
    public ProjectMemberNotFoundException() {
        super(MESSAGE);
    }
}

