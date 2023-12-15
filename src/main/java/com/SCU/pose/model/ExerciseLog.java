package com.SCU.pose.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "exercise_logs")
public class ExerciseLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @Column(nullable = false)
    private int userId;

    private String exerciseType; // 'push-ups', 'plank'
    private int count; // 用于次数型运动
    private int duration; // 用于时间型运动，单位为秒

    private LocalDate logDate;

    // 构造函数
    public ExerciseLog() {
        // 默认构造函数
    }
    public ExerciseLog(int userId, String exerciseType, int count, int duration, LocalDate logDate) {
        this.userId = userId;
        this.exerciseType = exerciseType;
        this.count = count;
        this.duration = duration;
        this.logDate = logDate;
    }

    // Getter和Setter方法
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
}
