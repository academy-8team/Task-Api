/**
 * packageName :  com.nhnacademy.task.entity
 * fileName : Tag
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity;

import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tags")
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_num")
    private Project project;

    private String tagTitle;

    @Builder
    public Tag(Project project, String tagTitle) {
        this.project = project;
        this.tagTitle = tagTitle;
    }
}
