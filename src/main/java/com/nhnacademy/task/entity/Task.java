/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : Task
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tasks")
public class Task extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_num")
    private Project project;

    private String taskTitle;

    private String taskContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_num")
    private Milestone milestone;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TaskTag> taskTags = new ArrayList<>();

    @Builder
    public Task(Project project, String taskTitle, String taskContent) {
        this.project = project;
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
    }
}
