package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nhnacademy.task.entity.enums.ProjectState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNum;

    private String projectName;

    private String projectDescription;

    @Enumerated(EnumType.STRING)
    private ProjectState projectState;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> tasks;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectMember> projectMembers;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Tag> tags;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Milestone> milestones;
}
