package com.c1x.manytomany.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "stu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stu_name")
    private String name;

}


