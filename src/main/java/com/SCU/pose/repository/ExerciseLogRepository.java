package com.SCU.pose.repository;

import com.SCU.pose.model.ExerciseLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Integer> {
    // 通过用户 ID 查找运动日志
    List<ExerciseLog> findByUserId(Integer userId);

    // 通过运动类型查找运动日志
    List<ExerciseLog> findByExerciseType(String exerciseType);

    // 可以根据需要添加更多查询方法
}
