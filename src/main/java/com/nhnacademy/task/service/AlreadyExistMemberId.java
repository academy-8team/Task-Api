/**
 * packageName :  com.nhnacademy.task.service
 * fileName : AlreadyExistMemberId
 * author :  ichunghui
 * date : 2023/06/07 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/07                ichunghui             최초 생성
 */

package com.nhnacademy.task.service;

public class AlreadyExistMemberId extends RuntimeException {
    public static final String MESSAGE = "이미 존재하는 아이디입니다.";
    public AlreadyExistMemberId() {
        super(MESSAGE);
    }
}