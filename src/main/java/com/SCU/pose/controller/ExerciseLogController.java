package com.SCU.pose.controller;

import com.SCU.pose.model.ExerciseLog;
import com.SCU.pose.service.ExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise-logs")
public class ExerciseLogController {

    @Autowired
    private ExerciseLogService exerciseLogService;

    @PostMapping
    public ResponseEntity<ExerciseLog> createExerciseLog(@RequestBody ExerciseLog log) {
        ExerciseLog savedLog = exerciseLogService.saveExerciseLog(log);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping("/{logId}")
    public ResponseEntity<ExerciseLog> getExerciseLogById(@PathVariable Integer logId) {
        return exerciseLogService.getExerciseLogById(logId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ExerciseLog> getAllExerciseLogs() {
        return exerciseLogService.getAllExerciseLogs();
    }

    @PutMapping("/{logId}")
    public ResponseEntity<ExerciseLog> updateExerciseLog(@PathVariable Integer logId, @RequestBody ExerciseLog log) {
        log.setLogId(logId);
        ExerciseLog updatedLog = exerciseLogService.updateExerciseLog(log);
        return ResponseEntity.ok(updatedLog);
    }

    @DeleteMapping("/{logId}")
    public ResponseEntity<?> deleteExerciseLog(@PathVariable Integer logId) {
        exerciseLogService.deleteExerciseLog(logId);
        return ResponseEntity.ok().build();
    }
}
