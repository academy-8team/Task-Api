package com.nhnacademy.task.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // todo 5 -  Tag Entity에  Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_num")
    private Long tagNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @Column(name = "tag_title")
    private String tagTitle;
}
