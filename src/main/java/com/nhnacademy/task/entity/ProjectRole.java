/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : ProjectRole
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

public enum ProjectRole {
    PROJECT_ROLE_ADMIN {
        @Override
        public String toString() {
            return "PROJECT_ROLE_ADMIN";
        }
    },
    PROJECT_ROLE_USER {
        @Override
        public String toString() {
            return "PROJECT_ROLE_USER";
        }
    }
}
