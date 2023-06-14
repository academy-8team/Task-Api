/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : ProjectNotAddMember
 * author :  ichunghui
 * date : 2023/06/14 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/14                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class ProjectNotAddMember extends RuntimeException{
    public static final String MESSAGE = "프로젝트에 멤버를 추가하는데 실패했습니다.";
    public ProjectNotAddMember() {
        super();
    }
}

