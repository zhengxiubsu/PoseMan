package com.SCU.pose.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "PushUp")
public class PushUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    private int count;

    private Date date;

    private int score;

    private String comments;



}
