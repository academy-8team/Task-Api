package com.nhnacademy.task.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private ProjectStatus projectStatus;

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
