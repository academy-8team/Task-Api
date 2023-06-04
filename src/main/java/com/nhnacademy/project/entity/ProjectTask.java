/**
 * packageName :  com.nhnacademy.project.entity
 * fileName : ProjectTask
 * author :  ichunghui
 * date : 2023/06/05 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/05                ichunghui             최초 생성
 */

package com.nhnacademy.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "project_tasks")
@Table
@Getter
@Setter
public class ProjectTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_task_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}

