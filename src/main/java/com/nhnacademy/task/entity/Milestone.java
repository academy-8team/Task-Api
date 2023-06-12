package com.nhnacademy.task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "milestones")
public class Milestone extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_id")
    private Long milestoneId;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "milestone_title")
    private String milestoneTitle;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public Milestone(String milestoneTitle, Project project) {
        this.milestoneTitle = milestoneTitle;
        this.project = project;
    }

    public void updateMilestoneTitle(String milestoneTitle) {
        this.milestoneTitle = milestoneTitle;
    }
}
