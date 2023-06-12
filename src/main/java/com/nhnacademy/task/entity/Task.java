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
    @Column(name = "task_id")
    private Long taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_Id")
    private Project project;

    @Column(name = "task_title")
    private String taskTitle;


    @Column(name = "task_content")
    private String taskContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<TaskTag> taskTags = new ArrayList<>();

    @Builder
    public Task(Project project, String taskTitle, String taskContent) {
        this.project = project;
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
    }

    public void update(String taskTitle, String taskContent) {
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
    }
}
