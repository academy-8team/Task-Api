/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : MilestoneNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class MilestoneNotFoundException extends RuntimeException{
    public static final String MESSAGE = "마일스톤을 찾을 수 없습니다.";
    public MilestoneNotFoundException() {
        super(MESSAGE);
    }
}

