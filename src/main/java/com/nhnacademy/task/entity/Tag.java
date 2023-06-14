package com.nhnacademy.task.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    private String tagTitle;
}
