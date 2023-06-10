package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "milestones")
public class Milestone extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milestoneNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_num")
    private Project project;

    private String milestoneTitle;

    @OneToOne(mappedBy = "milestone", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Task task;

    @Builder
    public Milestone(Project project, String milestoneTitle) {
        this.project = project;
        this.milestoneTitle = milestoneTitle;
    }
}
