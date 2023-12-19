package com.SCU.pose.model;


import javax.persistence.*;

@Entity
@Table(name = "GluteBridge")
public class GluteBridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;
}
