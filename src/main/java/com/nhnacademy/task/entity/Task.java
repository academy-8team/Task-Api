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
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_num")
    private Milestone milestone;

    private String taskTitle;

    private String taskContent;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Comment> comments;
}
