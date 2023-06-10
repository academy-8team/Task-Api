package com.nhnacademy.task.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNum;

    @ManyToOne
    @JoinColumn(name = "task_num")
    private Task task;

    private String commentContent;

    private String writerId;

    @Builder
    public Comment(Task task, String commentContent, String writerId) {
        this.task = task;
        this.commentContent = commentContent;
        this.writerId = writerId;
    }
}