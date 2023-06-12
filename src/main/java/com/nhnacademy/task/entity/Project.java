package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "projects")
public class Project extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "project_name")
    private String projectName;

    @Size(max=200)
    @Column(name = "project_description")
    private String projectDescription;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<ProjectMember> projectMembers = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Milestone> milestones = new ArrayList<>();

    @Builder
    public Project(String projectName, String projectDescription, ProjectStatus projectStatus) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
    }

    public void updateAttributes(String projectName, String projectDescription, ProjectStatus projectStatus) {
        Project updatedProject = Project.builder()
                .projectName(projectName)
                .projectDescription(projectDescription)
                .projectStatus(projectStatus)
                .build();

        this.projectName = updatedProject.projectName;
        this.projectDescription = updatedProject.projectDescription;
        this.projectStatus = updatedProject.projectStatus;
    }

}
