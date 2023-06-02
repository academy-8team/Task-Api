package com.nhnacademy.project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Projects")
@Getter
@Setter
public class Project extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ProjectStatus status;
}