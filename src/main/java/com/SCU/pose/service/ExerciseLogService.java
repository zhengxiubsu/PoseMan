package com.SCU.pose.service;

import com.SCU.pose.model.ExerciseLog;
import com.SCU.pose.repository.ExerciseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseLogService {
    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    public ExerciseLog saveExerciseLog(ExerciseLog exerciseLog) {
        return exerciseLogRepository.save(exerciseLog);
    }

    public Optional<ExerciseLog> getExerciseLogById(Integer logId) {
        return exerciseLogRepository.findById(logId);
    }

    public List<ExerciseLog> getAllExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    public void deleteExerciseLog(Integer logId) {
        exerciseLogRepository.deleteById(logId);
    }

    public ExerciseLog updateExerciseLog(ExerciseLog exerciseLog) {
        return exerciseLogRepository.save(exerciseLog); // save 方法用于创建和更新
    }

    // 可能的额外方法
    public List<ExerciseLog> findByUserId(Integer userId) {
        return exerciseLogRepository.findByUserId(userId);
    }

    public List<ExerciseLog> findByExerciseType(String exerciseType) {
        return exerciseLogRepository.findByExerciseType(exerciseType);
    }

    // 其他业务逻辑方法
}
