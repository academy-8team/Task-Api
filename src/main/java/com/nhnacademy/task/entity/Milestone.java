package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    private String milestoneTitle;

    @OneToOne(mappedBy = "milestone")
    @JsonIgnore
    private Task task;
}
