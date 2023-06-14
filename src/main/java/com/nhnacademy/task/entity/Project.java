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
@Entity // todo 3 : Project  Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_num")
    private Long projectNum;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_state")
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
