package com.SCU.pose.model;

import javax.persistence.*;

@Entity
@Table(name = "SitUp")
public class SitUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;
}
