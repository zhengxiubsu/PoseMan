package com.SCU.pose.model;

import javax.persistence.*;

@Entity
@Table(name = "Plank")
public class Plank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String label;

}
