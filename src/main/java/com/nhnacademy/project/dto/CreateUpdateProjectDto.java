package com.nhnacademy.project.dto;

import lombok.Data;

@Data
public class CreateUpdateProjectDto {
    private String name;
    private String content;
    private String status;
}