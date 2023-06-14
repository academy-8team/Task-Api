package com.nhnacademy.task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter  // todo 1 : Comment Entity에 Setter를 제거하고, Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_num")
    private Long commentNum;

    @ManyToOne
    @JoinColumn(name = "task_num")
    private Task task;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "writer_id")
    @Size(min = 1, max = 15)
    private String writerId;
}
