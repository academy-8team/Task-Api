package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // todo6 - Task Entity에 Setter를 제거하고, Builder를 테이블 전체에 사용하지 않도록 한다. 필요하다면 update 메서드를 추가한다.
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_num")
    private Long taskNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_num")
    private Milestone milestone;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Comment> comments;
}
