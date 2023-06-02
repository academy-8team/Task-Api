package com.nhnacademy.project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
public class Task extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;
}