/**
 * packageName :  com.nhnacademy.project.entity
 * fileName : TaskMileStone
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

@Entity(name = "task_milestones")
@Table
@Getter
@Setter
public class TaskMileStone extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_milstone_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;
}

