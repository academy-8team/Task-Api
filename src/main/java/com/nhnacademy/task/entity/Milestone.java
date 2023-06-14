package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity //todo 2 : Milestone Entity에 Setter를 제거하고, Builder를 테이블 전체에 사용하지 않도록 한다. 또한 네이밍 규칙을 고려하여 고친다. 필요하다면 update 메서드를 추가한다.
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_num")
    private Long milestoneNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @Column(name = "milestone_title")
    @Size(min = 2, max = 30)
    @Length(min = 2, max = 30)
    private String milestoneTitle;

    @OneToOne(mappedBy = "milestone")
    @JsonIgnore
    private Task task;
}
