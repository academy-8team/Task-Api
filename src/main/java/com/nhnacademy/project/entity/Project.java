package com.nhnacademy.project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Projects")
@Getter
@Setter
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", nullable = false)
    private Long id;

    @Size(min = 1, max = 30)
    private String name;

    @Column(name = "content", length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ProjectStatus status;


    @OneToMany(mappedBy = "project", orphanRemoval = true)
    private Set<ProjectTask> projectTasks = new LinkedHashSet<>();

}