package com.nhnacademy.task.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
public class Task extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 500)
    private String content;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "task", orphanRemoval = true)
    private Set<TaskMileStone> taskMileStones = new LinkedHashSet<>();

}