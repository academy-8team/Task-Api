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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_num")
    private Milestone milestone;

    private String taskTitle;

    private String taskContent;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Comment> comments;
}
