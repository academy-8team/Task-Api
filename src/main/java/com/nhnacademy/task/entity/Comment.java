/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : Comment
 * author :  ichunghui
 * date : 2023/06/11 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/11                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comments")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "comment_content")
    private String commentContent;

    @Builder
    public Comment(Task task, String commentContent) {
        this.task = task;
        this.commentContent = commentContent;
    }

    public void updateContent(String content) {
        this.commentContent = content;
    }
}