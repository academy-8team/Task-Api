package com.nhnacademy.project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Milestones")
@Getter
@Setter
public class Milestone extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "milestone_id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "milestone", orphanRemoval = true)
    private Set<TaskMileStone> taskMileStones = new LinkedHashSet<>();
}