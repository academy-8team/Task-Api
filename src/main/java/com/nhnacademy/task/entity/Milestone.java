package com.nhnacademy.task.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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
