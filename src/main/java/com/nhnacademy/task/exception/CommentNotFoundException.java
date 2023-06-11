/**
 * packageName :  com.nhnacademy.task.exception
 * fileName : CommentNotFoundException
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.exception;

public class CommentNotFoundException extends RuntimeException {
    public static final String MESSAGE = "댓글을 찾을 수 수 없습니다.";
    public CommentNotFoundException() {
        super(MESSAGE);
    }
}

