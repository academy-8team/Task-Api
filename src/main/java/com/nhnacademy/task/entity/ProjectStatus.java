package com.nhnacademy.task.entity;

public enum ProjectStatus {
    ACTIVE {
        @Override
        public String toString() {
            return "ACTIVE";
        }
    }, DORMANT {
        @Override
        public String toString() {
            return "DORMANT";
        }
    }, SHUTDOWN {
        @Override
        public String toString() {
            return "SHUTDOWN";
        }
    }
}
