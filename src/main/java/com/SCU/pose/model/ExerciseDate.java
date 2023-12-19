package com.SCU.pose.model;

import javax.persistence.*;

@Entity
@Table(name = "ExerciseDate")
public class ExerciseDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;
}
