package com.nhnacademy.task.entity.enums;

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
