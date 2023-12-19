package com.SCU.pose.model;

import javax.persistence.*;

@Entity
@Table(name = "FlutterKicks")
public class FlutterKicks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

}
